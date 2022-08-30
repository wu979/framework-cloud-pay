package com.framework.cloud.pay.common.vo.pay.wx;

import com.framework.cloud.pay.common.vo.pay.PayWxVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信公众号支付
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayWxJsApiVO extends PayWxVO {
    private static final long serialVersionUID = -1186349924446568444L;
}
