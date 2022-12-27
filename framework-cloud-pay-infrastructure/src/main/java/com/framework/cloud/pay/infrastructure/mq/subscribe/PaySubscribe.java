package com.framework.cloud.pay.infrastructure.mq.subscribe;

import com.framework.cloud.pay.infrastructure.mq.channel.PayOrderChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * 支付领域事件订阅
 *
 * @author wusiwei
 */
@Slf4j
@EnableBinding(PayOrderChannel.class)
public class PaySubscribe {

    @StreamListener(PayOrderChannel.IN)
    public void gatewayRouteEvent(@Payload String num) {
        log.info("收到消息:{}", num);
    }

}
