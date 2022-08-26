package com.framework.cloud.pay.common.dto.pay;

import com.framework.cloud.enums.platform.PayChannelType;
import com.framework.cloud.enums.platform.PayModeType;

import java.io.Serializable;

/**
 * 支付 父类
 *
 * @author wusiwei
 */
public abstract class PayDTO implements Serializable {
    private static final long serialVersionUID = -1208274739955551745L;

    public abstract PayChannelType getPayChannelType();

    public abstract PayModeType getPayModeType();
}
