package com.framework.cloud.pay.common.dto.pay;

import com.framework.cloud.enums.platform.PayChannelType;
import com.framework.cloud.enums.platform.PayModeType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 支付 父类
 *
 * @author wusiwei
 */
public abstract class PayDTO implements Serializable {
    private static final long serialVersionUID = -1208274739955551745L;

    @ApiModelProperty(value = "支付方式")
    private Long modeId;

    public abstract PayChannelType getPayChannelType();

    public abstract PayModeType getPayModeType();

    public Long getModeId() {
        return modeId;
    }

    public void setModeId(Long modeId) {
        this.modeId = modeId;
    }
}
