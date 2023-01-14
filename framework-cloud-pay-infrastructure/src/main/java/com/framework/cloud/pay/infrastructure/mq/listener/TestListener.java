package com.framework.cloud.pay.infrastructure.mq.listener;

import com.framework.cloud.common.base.RabbitMessage;
import com.framework.cloud.pay.common.dto.order.PayOrderDTO;
import com.framework.cloud.pay.common.stream.TestMessage;
import com.framework.cloud.pay.domain.service.PayOrderService;
import com.framework.cloud.stream.rabbit.listener.MessageListener;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author wusiwei
 */
@Component
@AllArgsConstructor
public class TestListener extends MessageListener<TestMessage> {

    private final PayOrderService payOrderService;

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "direct.mode", durable = "true", type = "direct"),
            value = @Queue(value = "queue.direct", durable = "true"),
            key = "test.route"
    ))
    @Override
    protected void receiveMessage(Message message, Channel channel) {
        super.receiveMessage(message, channel);
    }

    @Override
    public void consumeMessage(Message message, RabbitMessage<TestMessage> rabbitMessage) {
        payOrderService.save(new PayOrderDTO());
    }

}
