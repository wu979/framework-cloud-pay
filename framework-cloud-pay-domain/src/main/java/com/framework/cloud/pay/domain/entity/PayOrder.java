package com.framework.cloud.pay.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.cloud.common.base.BaseTenant;
import com.framework.cloud.enums.pay.PayStatus;
import com.framework.cloud.enums.platform.PayModeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付订单 实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_pay_order")
@ApiModel(value = "支付订单对象", description = "支付订单")
public class PayOrder extends BaseTenant {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "支付订单号")
    private String num;

    @ApiModelProperty(value = "业务单号")
    private String orderNum;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "支付完成时间")
    private LocalDateTime successTime;

    @TableField("`status`")
    @ApiModelProperty(value = "支付状态")
    private PayStatus status;

    @TableField("`type`")
    @ApiModelProperty(value = "支付类型")
    private PayModeType type;

    @ApiModelProperty(value = "微信支付订单号")
    private String tradeId;

    @ApiModelProperty(value = "微信支付交易状态")
    private String tradeStatus;

    @ApiModelProperty(value = "备注")
    private String remarks;

}