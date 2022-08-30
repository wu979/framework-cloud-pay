package com.framework.cloud.pay.common.dto.pay.wx;

import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import lombok.*;

/**
 * 微信H5支付
 *
 * @author wusiwei
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class PayWxWebDTO  extends PayWxDTO {
    private static final long serialVersionUID = -2436707533695062376L;

    @Override
    public PayModeType getPayModeType() {
        return PayModeType.WX_MWEB;
    }
}
