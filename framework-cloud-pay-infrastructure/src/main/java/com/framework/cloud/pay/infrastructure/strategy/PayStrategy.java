package com.framework.cloud.pay.infrastructure.strategy;

import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.pay.PayDTO;
import com.framework.cloud.pay.common.vo.pay.PayVO;
import com.framework.cloud.pay.domain.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 统一支付 策略选择器
 *
 * @author wusiwei
 */
@Component
public class PayStrategy<R extends PayVO, T extends PayDTO> {

    @Autowired
    private Map<String, PayService<R, T>> payServiceMap;

    public R payService(T param) {
        PayModeType payModeType = param.getPayModeType();
        PayService<R, T> payService = payServiceMap.get(payModeType.getValue());
        return payService.pay(param);
    }
}
