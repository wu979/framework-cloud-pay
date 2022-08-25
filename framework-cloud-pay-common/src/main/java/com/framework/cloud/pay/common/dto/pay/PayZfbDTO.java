package com.framework.cloud.pay.common.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 支付宝 支付父类DTO
 *
 * @author wusiwei
 */
@Data
public class PayZfbDTO implements Serializable {
    private static final long serialVersionUID = 9103355160992331664L;

    @NotEmpty(message = "业务订单号必填!")
    @ApiModelProperty(value = "业务订单号")
    private String orderNo;

    @NotNull(message = "订单总金额必填!")
    @DecimalMin(value = "0", message = "订单总金额必须为正数")
    @ApiModelProperty(value = "订单总金额")
    private BigDecimal orderAmount;

    @NotEmpty(message = "商品描述必填!")
    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "附加数据(回调返回)")
    private String attach;

    /**
     * 如 订单无需传下面的值 默认为Null 不参与Valid验证 需要传值 请注意必传值
     */
    @Valid
    @Size(min = 0, max = 6000, message = "商品详情信息最大支持6000条!")
    @ApiModelProperty(value = "商品详情信息")
    private List<GoodsDetailDTO> goodsDetail;


    @Data
    @ApiModel("支付宝支付-商品列表参数")
    public static class GoodsDetailDTO {

        @ApiModelProperty(value = "支付宝定义的统一商品编号（没有可不传）")
        private String goodsId;

        @NotEmpty(message = "商品id必填!")
        @ApiModelProperty(value = "商品id")
        private String skuId;

        @NotEmpty(message = "商品名称必填!")
        @ApiModelProperty(value = "商品名称")
        private String goodsName;

        @NotNull(message = "购买数量必填!")
        @Min(value = 1, message = "购买数量不能小于1!")
        @ApiModelProperty(value = "购买数量")
        private Integer quantity;

        @NotNull(message = "商品单价必填!")
        @DecimalMin(value = "0", message = "商品单价必须为正数!")
        @ApiModelProperty(value = "商品单价(单位：分)")
        private BigDecimal unitPrice;

        @ApiModelProperty(value = "商品类目")
        private String goodsCategory;

        @ApiModelProperty(value = "商品类目树")
        private String categoriesTree;

        @ApiModelProperty(value = "商品的展示地址")
        private String showUrl;

    }
}
