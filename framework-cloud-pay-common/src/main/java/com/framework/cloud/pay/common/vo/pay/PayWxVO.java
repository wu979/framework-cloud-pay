package com.framework.cloud.pay.common.vo.pay;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信 父类
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayWxVO extends PayVO {
    private static final long serialVersionUID = 2852952869232173578L;
}
