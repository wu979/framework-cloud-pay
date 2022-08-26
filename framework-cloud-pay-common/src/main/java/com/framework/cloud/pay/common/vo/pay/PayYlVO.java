package com.framework.cloud.pay.common.vo.pay;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 银联 父类
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayYlVO extends PayVO {
    private static final long serialVersionUID = -7132728036170525881L;
}
