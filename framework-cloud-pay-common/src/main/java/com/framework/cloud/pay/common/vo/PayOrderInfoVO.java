package com.framework.cloud.pay.common.vo;

import com.framework.cloud.common.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 支付订单 详情VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayOrderInfoVO extends BaseVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "业务id")
    private Long businessId;

    @ApiModelProperty(value = "支付订单号")
    private String num;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "支付状态")
    private String payStatus;

    @ApiModelProperty(value = "备注")
    private String remarks;

}