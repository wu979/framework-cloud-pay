package com.framework.cloud.pay.common.dto.pay;

import com.framework.cloud.common.constant.HttpConstant;
import com.framework.cloud.common.utils.RegexUtil;
import com.framework.cloud.enums.platform.PayChannelType;
import com.framework.cloud.enums.platform.PayModeType;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.AssertTrue;
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

    @NotEmpty(message = "请传入回调地址!")
    @ApiModelProperty(value = "回调地址")
    private String callbackUrl;

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

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @AssertTrue(message = "非法回调地址!")
    private boolean isCallbackUrl() {
        if (this.callbackUrl.startsWith(HttpConstant.LB)) {
            return true;
        } else if (this.callbackUrl.startsWith(HttpConstant.HTTP)) {
            return true;
        } else if (this.callbackUrl.startsWith(HttpConstant.HTTPS)) {
            return true;
        } else {
            return RegexUtil.checkIpAddress(this.callbackUrl);
        }
    }
}
