package com.framework.cloud.pay.common.vo.pay;

import com.framework.cloud.enums.pay.PayStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 支付 父类
 *
 * @author wusiwei
 */
@Data
public class PayVO implements Serializable {
    private static final long serialVersionUID = -7957672890638603129L;

    @ApiModelProperty(value = "业务订单号")
    private String orderNo;

    @ApiModelProperty(value = "支付订单号")
    private String payNo;

    @ApiModelProperty(value = "支付状态")
    private PayStatus status;
}
