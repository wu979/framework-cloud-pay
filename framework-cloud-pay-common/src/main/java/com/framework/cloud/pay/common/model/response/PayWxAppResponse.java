package com.framework.cloud.pay.common.model.response;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 微信唤醒支付 返回值
 *
 * @author wusiwei
 */
@Data
public class PayWxAppResponse {

    @JSONField(name = "prepay_id")
    @ApiModelProperty(value = "预支付交易会话标识")
    private String prepayId;

}
