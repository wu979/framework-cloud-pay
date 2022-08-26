package com.framework.cloud.pay.infrastructure.repository;

import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.pay.common.vo.order.PayNotifyInfoVO;
import com.framework.cloud.pay.domain.entity.PayNotify;
import com.framework.cloud.pay.domain.repository.PayNotifyRepository;
import com.framework.cloud.pay.infrastructure.converter.PayNotifyConverter;
import com.framework.cloud.pay.infrastructure.mapper.PayNotifyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 *  数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class PayNotifyRepositoryImpl extends BaseRepositoryImpl<PayNotifyMapper, PayNotify> implements PayNotifyRepository {

    private final PayNotifyConverter payNotifyConverter;

    @Override
    public PayNotifyInfoVO info(Long id) {
        PayNotify payNotify = this.getById(id);
        return payNotifyConverter.info(payNotify);
    }
}