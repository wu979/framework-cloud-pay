package com.framework.cloud.pay.infrastructure.converter;

import com.framework.cloud.pay.common.vo.order.PayOrderInfoVO;
import com.framework.cloud.pay.domain.entity.PayOrder;
import org.mapstruct.Mapper;

/**
 * 支付订单 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface PayOrderConverter {

    /**
     * 支付订单 详情转换
     *
     * @param payOrder 实体
     * @return 详情
     */
    PayOrderInfoVO info(PayOrder payOrder);

}