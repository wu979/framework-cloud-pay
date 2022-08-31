package com.framework.cloud.pay.infrastructure.mq.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 支付订单 领域事件
 *
 * @author wusiwei
 */
public interface PayOrderChannel {

    String OUT = "pay-order-ouput-channel";

    @Output(OUT)
    MessageChannel output();

    String IN = "pay-order-input-channel";

    @Input(IN)
    SubscribableChannel input();
}
