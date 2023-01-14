package com.framework.cloud.pay.infrastructure.mq.publish;

import com.framework.cloud.common.base.StreamMessage;
import com.framework.cloud.pay.common.stream.PayOrderMessage;
import com.framework.cloud.pay.infrastructure.mq.PayPublish;
import com.framework.cloud.pay.infrastructure.mq.channel.PayOrderChannel;
import com.framework.cloud.stream.properties.StreamProperties;
import com.framework.cloud.stream.utils.MessageBuilderUtil;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

import static com.framework.cloud.stream.constant.StreamConstant.TIMEOUT;
/**
 * @author wusiwei
 */
@Component
@AllArgsConstructor
@EnableBinding({PayOrderChannel.class})
@EnableConfigurationProperties(StreamProperties.class)
public class PayPublishImpl implements PayPublish {

    private final PayOrderChannel payOrderChannel;

    @Override
    public boolean publishPayOrder(StreamMessage<PayOrderMessage.OrderInsert> message) {
        return payOrderChannel.output().send(MessageBuilderUtil.build(message, PayOrderChannel.OUT), TIMEOUT);
    }
}
