package com.framework.cloud.pay.common.dto.pay;

import com.framework.cloud.enums.platform.PayChannelType;
import com.framework.cloud.enums.platform.PayModeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 支付 父类
 *
 * @author wusiwei
 */
@FieldNameConstants
public abstract class PayDTO implements Serializable {
    private static final long serialVersionUID = -1208274739955551745L;

    @NotNull(message = "请选择支付方式!")
    @ApiModelProperty(value = "支付方式")
    private Long modeId;

    @NotEmpty(message = "业务订单号必填!")
    @ApiModelProperty(value = "业务订单号")
    private String orderNo;

    @NotNull(message = "下单时间必填!")
    @ApiModelProperty(value = "下单时间")
    private Long orderTime;

    @NotEmpty(message = "非法签名!")
    @ApiModelProperty(value = "签名")
    private String sign;

    public abstract PayChannelType getPayChannelType();

    public abstract PayModeType getPayModeType();

    public Long getModeId() {
        return modeId;
    }

    public void setModeId(Long modeId) {
        this.modeId = modeId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
