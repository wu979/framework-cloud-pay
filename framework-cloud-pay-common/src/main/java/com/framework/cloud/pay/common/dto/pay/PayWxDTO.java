package com.framework.cloud.pay.common.dto.pay;

import com.framework.cloud.enums.platform.PayChannelType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 微信 父类
 *
 * @author wusiwei
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public abstract class PayWxDTO extends PayDTO {
    private static final long serialVersionUID = -7153752520751883671L;

    @NotEmpty(message = "业务订单号必填!")
    @ApiModelProperty(value = "业务订单号")
    private String orderNo;

    @NotEmpty(message = "商品描述必填!")
    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "附加数据(回调返回)")
    private String attach;

    @Valid
    @NotNull(message = "订单金额信息必填!")
    @ApiModelProperty(value = "订单金额信息")
    private AmountDTO orderAmount;

    /**
     * 如 订单无需传下面的值 默认为Null 不参与Valid验证 需要传值 请注意必传值
     */
    @Valid
    @Size(min = 0, max = 6000, message = "商品详情信息最大支持6000条!")
    @ApiModelProperty(value = "商品详情信息")
    private List<GoodsDetailDTO> goodsDetail;

    @Valid
    @ApiModelProperty(value = "支付场景描述")
    private SceneInfoDTO sceneInfo;

    @Valid
    @ApiModelProperty(value = "商户门店信息")
    private StoreInfoDTO storeInfo;

    @ApiModelProperty(value = "优惠功能信息")
    private SettleInfoDTO detail;

    @ApiModelProperty(value = "结算信息")
    private DiscountDetailDTO settleInfo;

    @Override
    public PayChannelType getPayChannelType() {
        return PayChannelType.WX;
    }

    @Data
    @ApiModel("微信支付-金额参数")
    public static class AmountDTO {

        @NotNull(message = "订单总金额必填!")
        @DecimalMin(value = "0", message = "订单总金额必须为正数")
        @ApiModelProperty(value = "订单总金额")
        private BigDecimal total;

        @ApiModelProperty(value = "货币类型(示例值：CNY)")
        private String currency;

    }

    @Data
    @ApiModel("微信支付-商品列表参数")
    public static class GoodsDetailDTO {

        @ApiModelProperty(value = "微信支付定义的统一商品编号（没有可不传）")
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
        private int quantity;

        @NotNull(message = "商品单价必填!")
        @DecimalMin(value = "0", message = "商品单价必须为正数!")
        @ApiModelProperty(value = "商品单价(单位：分)")
        private BigDecimal unitPrice;

    }

    @Data
    @ApiModel("微信支付-支付场景描述参数")
    public static class SceneInfoDTO {

        @NotEmpty(message = "用户终端IP必填!")
        @ApiModelProperty(value = "用户终端IP")
        private String clientIp;

        @ApiModelProperty(value = "商户端设备号")
        private String deviceId;

    }

    @Data
    @ApiModel("微信支付-商户门店信息参数")
    public static class StoreInfoDTO {

        @NotEmpty(message = "门店编号必填!")
        @ApiModelProperty(value = "门店编号")
        private String id;

        @ApiModelProperty(value = "门店名称")
        private String name;

        @ApiModelProperty(value = "地区编码")
        private String areaCode;

        @ApiModelProperty(value = "详细地址")
        private String address;

    }

    @Data
    @ApiModel("微信支付-结算信息参数")
    public static class SettleInfoDTO {

        @ApiModelProperty(value = "是否指定分账")
        private Boolean profitSharing;

    }

    @Data
    @ApiModel("微信支付-优惠功能信息参数")
    public static class DiscountDetailDTO {

        @ApiModelProperty(value = "订单原价")
        private BigDecimal costPrice;

        @ApiModelProperty(value = "商品小票ID")
        private String invoiceId;

    }
}
