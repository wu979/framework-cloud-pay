package com.framework.cloud.pay.common.model.request;

import com.framework.cloud.pay.common.model.PayWxRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信唤醒支付 参数模型
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayWxAppRequest extends PayWxRequest {
    private static final long serialVersionUID = -8706695593820396826L;
}
