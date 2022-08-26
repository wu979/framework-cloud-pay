package com.framework.cloud.pay.common.dto.pay.wx;

import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import lombok.*;

/**
 * 微信唤醒支付
 *
 * @author wusiwei
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public final class PayWxAppDTO extends PayWxDTO {
    private static final long serialVersionUID = -7972629490523546509L;

    @Override
    public PayModeType getPayModeType() {
        return PayModeType.WX_APP;
    }
}
