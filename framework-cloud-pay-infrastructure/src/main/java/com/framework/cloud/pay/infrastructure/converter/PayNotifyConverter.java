package com.framework.cloud.pay.infrastructure.converter;

import com.framework.cloud.pay.common.vo.order.PayNotifyInfoVO;
import com.framework.cloud.pay.domain.entity.PayNotify;
import org.mapstruct.Mapper;

/**
 *  转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface PayNotifyConverter {

    /**
     *  详情转换
     *
     * @param payNotify 实体
     * @return 详情
     */
    PayNotifyInfoVO info(PayNotify payNotify);

}