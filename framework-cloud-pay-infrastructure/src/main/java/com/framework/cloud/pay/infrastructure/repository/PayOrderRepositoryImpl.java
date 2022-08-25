package com.framework.cloud.pay.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.pay.common.dto.order.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.order.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.order.PayOrderPageVO;
import com.framework.cloud.pay.domain.entity.PayOrder;
import com.framework.cloud.pay.domain.repository.PayOrderRepository;
import com.framework.cloud.pay.infrastructure.converter.PayOrderConverter;
import com.framework.cloud.pay.infrastructure.mapper.PayOrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 支付订单 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class PayOrderRepositoryImpl extends BaseRepositoryImpl<PayOrderMapper, PayOrder> implements PayOrderRepository {

    private final PayOrderConverter payOrderConverter;

    @Override
    public PageVO<PayOrderPageVO> page(PayOrderPageDTO param) {
        Page<PayOrderPageVO> page = PageParam.buildOrder(param);
        IPage<PayOrderPageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public PayOrderInfoVO info(Long id) {
        PayOrder payOrder = this.getById(id);
        return payOrderConverter.info(payOrder);
    }
}