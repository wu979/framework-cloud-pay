package com.framework.cloud.pay.infrastructure.service.abs;
import cn.hutool.core.lang.Pair;
import com.framework.cloud.common.utils.FastJsonUtil;
import com.framework.cloud.common.utils.MD5Util;
import com.framework.cloud.common.utils.RsaUtil;
import com.framework.cloud.pay.common.dto.pay.PayDTO;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import com.framework.cloud.pay.common.model.PayWxRequest;
import com.framework.cloud.pay.common.rpc.PayChannelInfoVO;
import com.framework.cloud.pay.common.rpc.PayModeInfoVO;
import com.framework.cloud.pay.common.vo.pay.PayWxVO;

import java.util.TreeMap;

/**
 * 微信支付 抽象
 *
 * @author wusiwei
 */
public abstract class AbstractPayWxService<R extends PayWxVO, T extends PayWxDTO, REQUEST extends PayWxRequest, RESPONSE> extends AbstractPayService<R, T, REQUEST, RESPONSE> {

    @Override
    protected Pair<Integer, String> check(PayModeInfoVO modeInfo, T param) {
        return null;
    }

    @Override
    protected boolean sign(PayChannelInfoVO channelInfo, T param) {
        TreeMap<String, String> signParam = new TreeMap<>();
        signParam.put(PayDTO.Fields.orderNo, param.getOrderNo());
        signParam.put(PayWxDTO.AmountDTO.Fields.total, param.getOrderAmount().getTotal().toPlainString());
        signParam.put(PayDTO.Fields.orderTime, param.getOrderTime().toString());
        String md5 = MD5Util.encode(FastJsonUtil.toJSONString(signParam));
        return RsaUtil.verifySign(md5, param.getSign(), channelInfo.getPublicKey());
    }

}
