package com.framework.cloud.pay.infrastructure.mq;

/**
 * 支付领域事件发布接口
 *
 * @author wusiwei
 */
public interface PayPublish {

    /**
     * 发布 支付订单延迟事件
     *
     * @param num 订单号
     * @return bool
     */
    boolean publishPayOrder(String num);
}
