package com.framework.cloud.pay.infrastructure.mq.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 支付订单 领域事件
 *
 * @author wusiwei
 */
public interface PayOrderChannel {

    String OUT = "pay-order-channel-output";

    @Output(OUT)
    MessageChannel output();

    String IN = "pay-order-channel-input";

    @Output(IN)
    MessageChannel input();
}
