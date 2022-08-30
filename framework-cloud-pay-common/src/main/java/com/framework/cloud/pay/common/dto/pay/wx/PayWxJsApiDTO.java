package com.framework.cloud.pay.common.dto.pay.wx;

import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 微信公众号支付
 *
 * @author wusiwei
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class PayWxJsApiDTO extends PayWxDTO {
    private static final long serialVersionUID = -167815595228665233L;

    @ApiModelProperty(value = "用户在直连商户appid下的唯一标识")
    private String openId;

    @Override
    public PayModeType getPayModeType() {
        return PayModeType.WX_JSAPI;
    }
}
