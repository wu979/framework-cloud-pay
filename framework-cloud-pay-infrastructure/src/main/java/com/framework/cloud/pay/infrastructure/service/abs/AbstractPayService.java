package com.framework.cloud.pay.infrastructure.service.abs;

import com.framework.cloud.pay.common.dto.pay.PayDTO;
import com.framework.cloud.pay.common.vo.pay.PayVO;
import com.framework.cloud.pay.domain.service.PayService;

/**
 * 统一支付 抽象
 *
 * @author wusiwei
 */
public abstract class AbstractPayService<R extends PayVO, T extends PayDTO, REQUEST, RESPONSE> implements PayService<R, T> {

    @Override
    public R pay(T param) {
        return result();
    }

    protected abstract R result();
}
