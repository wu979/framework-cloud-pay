package com.framework.cloud.pay.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.framework.cloud.common.base.BaseTenant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.framework.cloud.mybatis.annotation.LongToBigDecimal;
import lombok.*;

/**
 *  实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_pay_notify")
@ApiModel(value="对象", description="")
public class PayNotify extends BaseTenant {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "支付订单id")
    private Long payOrderId;

    @ApiModelProperty(value = "回调数据")
    private String resource;

}