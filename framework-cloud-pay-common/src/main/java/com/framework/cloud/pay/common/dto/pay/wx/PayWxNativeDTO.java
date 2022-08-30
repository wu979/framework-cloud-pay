package com.framework.cloud.pay.common.dto.pay.wx;

import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import lombok.*;

/**
 * 微信扫码支付
 *
 * @author wusiwei
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class PayWxNativeDTO extends PayWxDTO {
    private static final long serialVersionUID = -7577271377919225449L;

    @Override
    public PayModeType getPayModeType() {
        return PayModeType.WX_NATIVE;
    }
}
