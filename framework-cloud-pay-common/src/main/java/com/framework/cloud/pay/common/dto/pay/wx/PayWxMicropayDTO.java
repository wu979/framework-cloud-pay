package com.framework.cloud.pay.common.dto.pay.wx;

import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 微信付款码支付
 *
 * @author wusiwei
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class PayWxMicropayDTO extends PayWxDTO {
    private static final long serialVersionUID = 1825544471834017004L;

    @ApiModelProperty(value = "设备号")
    private String deviceInfo;

    @ApiModelProperty(value = "付款码", required = true)
    private String authCode;

    @Override
    public PayModeType getPayModeType() {
        return PayModeType.WX_MICROPAY;
    }
}
