package com.framework.cloud.pay.common.vo.pay;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付宝 父类
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayZfbVO extends PayVO {
    private static final long serialVersionUID = -7076119909187473922L;
}
