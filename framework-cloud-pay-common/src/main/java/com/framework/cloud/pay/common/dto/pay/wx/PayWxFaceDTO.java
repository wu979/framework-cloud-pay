package com.framework.cloud.pay.common.dto.pay.wx;

import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import lombok.*;

/**
 * 微信刷脸支付
 *
 * @author wusiwei
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class PayWxFaceDTO extends PayWxDTO {
    private static final long serialVersionUID = -3452714566371279975L;

    @Override
    public PayModeType getPayModeType() {
        return PayModeType.WX_FACEPAY;
    }
}
