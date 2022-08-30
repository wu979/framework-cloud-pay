package com.framework.cloud.pay.common.msg;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付消息
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
public enum PayMsg {

    /** 异常消息 */
    CREATE_PAY_ORDER_FAIL("创建支付订单失败"),
    ILLEGAL_SIGNATURE("非法签名"),
    PAY_FAIL("支付异常"),
    PAY_OVER_TIME("支付超时")
    ;

    private final String msg;
}
