package com.framework.cloud.pay.common.stream;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支付订单 消息体
 *
 * @author wusiwei
 */
public class PayOrderMessage {

    @Data
    @NoArgsConstructor
    public static class OrderInsert {

        private static final long serialVersionUID = 751558190282389306L;

        @ApiModelProperty(value = "订单号")
        private String num;

        public OrderInsert(String num) {
            this.num = num;
        }
    }
}
