package com.framework.cloud.pay.infrastructure.service;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.pay.common.dto.*;
import com.framework.cloud.pay.common.vo.*;
import com.framework.cloud.pay.domain.entity.PayOrder;
import com.framework.cloud.pay.domain.service.PayOrderService;
import com.framework.cloud.pay.domain.repository.PayOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 支付订单 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class PayOrderServiceImpl implements PayOrderService {

    private final PayOrderRepository payOrderRepository;

    @Override
    public PageVO<PayOrderPageVO> page(PayOrderPageDTO param) {
        return payOrderRepository.page(param);
    }

    @Override
    public PayOrderInfoVO info(Long id) {
        return payOrderRepository.info(id);
    }

    @Override
    public boolean save(PayOrderDTO param) {
        PayOrder payOrder = new PayOrder();
        CopierUtil.copyProperties(param, payOrder);
        return payOrderRepository.save(payOrder);
    }

    @Override
    public boolean update(PayOrderDTO param) {
        PayOrder payOrder = payOrderRepository.getByIdNotNull(param.getId());
        CopierUtil.copyProperties(param, payOrder);
        return payOrderRepository.updateById(payOrder);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return payOrderRepository.removeByIds(ids);
    }

}