package com.framework.cloud.pay.infrastructure.mq;

import com.framework.cloud.common.base.StreamMessage;
import com.framework.cloud.pay.common.stream.PayOrderMessage;
import com.framework.cloud.stream.domain.DomainPublish;

/**
 * 支付领域事件发布接口
 *
 * @author wusiwei
 */
public interface PayPublish extends DomainPublish {

    /**
     * 发布 支付订单延迟事件
     *
     * @param num 订单号
     * @return bool
     */
    boolean publishPayOrder(StreamMessage<PayOrderMessage.OrderInsert> message);
}
