package com.framework.cloud.pay.infrastructure.service.abs;

import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import com.framework.cloud.pay.common.model.PayWxRequest;
import com.framework.cloud.pay.common.vo.pay.PayWxVO;
import com.framework.cloud.pay.domain.entity.PayOrder;

/**
 * 微信支付 抽象
 *
 * @author wusiwei
 */
public abstract class AbstractPayWxService<R extends PayWxVO, T extends PayWxDTO, REQUESR extends PayWxRequest, RESPONSE> extends AbstractPayService<R, T, REQUESR, RESPONSE> {

    @Override
    protected PayOrder payOrder(T param) {
        return null;
    }
}
