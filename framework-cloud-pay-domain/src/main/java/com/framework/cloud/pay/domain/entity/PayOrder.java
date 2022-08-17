package com.framework.cloud.pay.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.cloud.common.base.BaseTenant;
import com.framework.cloud.mybatis.annotation.LongToBigDecimal;
import com.framework.cloud.pay.common.enums.PayStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
@ApiModel(value="支付订单对象", description="支付订单")
public class PayOrder extends BaseTenant {

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private Long id;
    
    @ApiModelProperty(value = "业务id")
    private Long businessId;
    
    @ApiModelProperty(value = "支付订单号")
    private String num;
    
    @LongToBigDecimal
    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;
    
    @ApiModelProperty(value = "支付状态")
    private PayStatus status;
    
    @ApiModelProperty(value = "备注")
    private String remarks;

}