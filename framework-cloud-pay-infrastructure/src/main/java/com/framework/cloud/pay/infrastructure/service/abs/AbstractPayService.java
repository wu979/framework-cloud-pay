package com.framework.cloud.pay.infrastructure.service.abs;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.exception.BizException;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.common.result.ResultApi;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.enums.pay.PayStatus;
import com.framework.cloud.pay.common.dto.pay.PayDTO;
import com.framework.cloud.pay.common.msg.PayMsg;
import com.framework.cloud.pay.common.rpc.PayChannelInfoVO;
import com.framework.cloud.pay.common.rpc.PayModeInfoVO;
import com.framework.cloud.pay.common.vo.pay.PayVO;
import com.framework.cloud.pay.domain.entity.PayOrder;
import com.framework.cloud.pay.domain.feign.PlatFormFeignService;
import com.framework.cloud.pay.domain.repository.PayOrderRepository;
import com.framework.cloud.pay.domain.service.PayService;

import javax.annotation.Resource;

/**
 * 统一支付 抽象
 *
 * @author wusiwei
 */
public abstract class AbstractPayService<R extends PayVO, T extends PayDTO, REQUEST, RESPONSE> implements PayService<R, T> {

    private static final int OVER_TIME = 5 * 60;

    @Resource
    private PlatFormFeignService platFormFeignService;

    @Resource
    private PayOrderRepository payOrderRepository;

    @Override
    public R pay(T param) {
        long differ = DateUtil.betweenMs(DateUtil.date(param.getOrderTime()), DateUtil.date()) / 1000;
        AssertUtil.isFalse(OVER_TIME - differ < 0, PayMsg.PAY_OVER_TIME.getMsg());
        Result<PayModeInfoVO> modeResult = platFormFeignService.modeInfo(param.getModeId());
        AssertUtil.isTrue(modeResult.success(), modeResult);
        PayModeInfoVO modeInfo = modeResult.getData();
        AssertUtil.isNull(modeInfo, modeResult);
        Result<PayChannelInfoVO> channelResult = platFormFeignService.channelInfo(modeInfo.getChannelId());
        AssertUtil.isTrue(modeResult.success(), channelResult);
        PayChannelInfoVO channelInfo = channelResult.getData();
        AssertUtil.isNull(channelInfo, modeResult);
        Pair<Integer, String> check = check(modeInfo, param);
        if (null != check) {
            throw new BizException(check.getKey(), check.getValue());
        }
        boolean sign = sign(channelInfo, param);
        AssertUtil.isTrue(sign, PayMsg.ILLEGAL_SIGNATURE.getMsg());
        REQUEST request = request(modeInfo, param);
        ResultApi<RESPONSE> pay;
        try {
            pay = tradePay(channelInfo, request);
        } catch (Exception e) {
            pay = new ResultApi<>(PayMsg.CREATE_PAY_ORDER_FAIL.getMsg());
        }
        if (!pay.getCall() || ObjectUtil.isNull(pay.getData())) {
            throw new BizException(pay.getMsg());
        }
        PayOrder payOrder = payOrder(request, pay.getData());
        boolean save = payOrderRepository.save(payOrder);
        if (!save) {
            throw new BizException(PayMsg.CREATE_PAY_ORDER_FAIL.getMsg());
        }
        // todo 订单延迟队列（半小时验证订单是否已支付）
        return result(payOrder.getOrderNum(), payOrder.getNum(), payOrder.getStatus());
    }

    /**
     * 检查
     *
     * @param modeInfo 支付方式
     * @param param 支付参数
     * @return 错误消息
     */
    protected abstract Pair<Integer, String> check(PayModeInfoVO modeInfo, T param);

    /**
     * 签名
     *
     * @param param 请求参数
     * @return bool
     */
    protected abstract boolean sign(PayChannelInfoVO channelInfo, T param);

    /**
     * 支付参数
     *
     * @param modeInfo 支付方式
     * @param param 请求参数
     * @return 支付参数
     */
    protected abstract REQUEST request(PayModeInfoVO modeInfo, T param);

    /**
     * 统一支付
     *
     * @param channelInfo 支付渠道
     * @param request 支付参数
     * @return 支付结果
     */
    protected abstract ResultApi<RESPONSE> tradePay(PayChannelInfoVO channelInfo, REQUEST request) throws Exception;

    /**
     * 支付订单
     *
     * @param request 支付参数
     * @param response 支付结果
     * @return 订单
     */
    protected abstract PayOrder payOrder(REQUEST request, RESPONSE response);

    /**
     * 支付结果
     *
     * @param orderNo 业务订单号
     * @param payNo 支付订单号
     * @param status 支付状态
     * @return 结果
     */
    protected abstract R result(String orderNo, String payNo, PayStatus status);

}
