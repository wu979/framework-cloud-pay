package com.framework.cloud.pay.common.dto;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

/**
 * 支付订单 新增修改DTO
 *
 * @author wusiwei
 */
@Data
public class PayOrderDTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "支付订单号")
    private String num;

    @ApiModelProperty(value = "业务id")
    private Long businessId;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
