package com.framework.cloud.pay.common.vo.pay.wx;

import com.framework.cloud.pay.common.vo.pay.PayWxVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信刷脸支付
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayWxFaceVO extends PayWxVO {
    private static final long serialVersionUID = -4475414679328439966L;
}
