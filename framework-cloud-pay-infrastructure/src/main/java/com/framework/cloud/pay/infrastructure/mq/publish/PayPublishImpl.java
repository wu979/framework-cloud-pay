package com.framework.cloud.pay.infrastructure.mq.publish;

import com.framework.cloud.stream.properties.PayDelayProperties;
import com.framework.cloud.pay.infrastructure.mq.PayPublish;
import com.framework.cloud.pay.infrastructure.mq.channel.PayOrderChannel;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static com.framework.cloud.stream.constant.StreamConstant.TIMEOUT;
import static com.framework.cloud.stream.constant.StreamConstant.HEADER_DELAY;
/**
 * @author wusiwei
 */
@Component
@AllArgsConstructor
@EnableBinding({PayOrderChannel.class})
@EnableConfigurationProperties(PayDelayProperties.class)
public class PayPublishImpl implements PayPublish {

    private final PayOrderChannel payOrderChannel;
    private final PayDelayProperties payDelayProperties;

    @Override
    public boolean publishPayOrder(String num) {
        return payOrderChannel.output().send(MessageBuilder.withPayload(num).setHeader(HEADER_DELAY, payDelayProperties.delay(PayOrderChannel.OUT)).build(), TIMEOUT);
    }
}
