package com.framework.cloud.pay.common.vo.pay.wx;

import com.framework.cloud.pay.common.vo.pay.PayWxVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信付款码支付
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayWxMicropayVO extends PayWxVO {
    private static final long serialVersionUID = -2108278285215429107L;
}
