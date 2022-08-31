package com.framework.cloud.pay.infrastructure.mq.publish;

import com.framework.cloud.pay.infrastructure.mq.PayPublish;
import com.framework.cloud.pay.infrastructure.mq.channel.PayOrderChannel;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wusiwei
 */
@Component
@AllArgsConstructor
@EnableBinding({PayOrderChannel.class})
public class PayPublishImpl implements PayPublish {

    private final PayOrderChannel payOrderChannel;

    @Override
    public boolean publishPayOrder(String num) {
        return payOrderChannel.output().send(MessageBuilder.withPayload(num).setHeader("x-delay", 5000).build(), 2000L);
    }
}
