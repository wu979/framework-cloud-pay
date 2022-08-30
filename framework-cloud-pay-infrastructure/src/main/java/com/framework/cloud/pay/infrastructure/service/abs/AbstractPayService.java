package com.framework.cloud.pay.infrastructure.service.abs;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.enums.GlobalMessage;
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

    @Resource
    private PlatFormFeignService platFormFeignService;

    @Resource
    private PayOrderRepository payOrderRepository;

    @Override
    public R pay(T param) {
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
        REQUEST request = request(modeInfo, param);
        ResultApi<RESPONSE> pay;
        try {
            pay = tradePay(channelInfo, request);
        } catch (Exception e) {
            pay = new ResultApi<>(GlobalMessage.THIRD_PARTY_CONNECTION_FAILED.getMsg());
        }
        PayOrder payOrder;
        if (!pay.getCall() || ObjectUtil.isNull(pay.getData())) {
            payOrder = payOrder(param);
        } else {
            payOrder = payOrder(request, pay.getData());
        }
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
     * @return null
     */
    protected abstract Pair<Integer, String> check(PayModeInfoVO modeInfo, T param);

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
     * @param param 请求参数
     * @return 订单
     */
    protected abstract PayOrder payOrder(T param);

    /**
     * 支付订单
     *
     * @param request 支付参数
     * @param response 支付结果
     * @return 订单
     */
    protected abstract PayOrder payOrder(REQUEST request, RESPONSE response);

    /**
     * 返回
     *
     * @param orderNo 业务订单号
     * @param payNo 支付订单号
     * @param status 支付状态
     * @return 返回体
     */
    protected abstract R result(String orderNo, String payNo, PayStatus status);

}
