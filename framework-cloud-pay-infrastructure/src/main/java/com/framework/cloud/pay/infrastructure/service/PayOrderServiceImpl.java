package com.framework.cloud.pay.infrastructure.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.common.utils.RandomUtil;
import com.framework.cloud.enums.pay.PayStatus;
import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.pay.common.dto.order.PayOrderDTO;
import com.framework.cloud.pay.common.dto.order.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.order.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.order.PayOrderPageVO;
import com.framework.cloud.pay.domain.entity.PayOrder;
import com.framework.cloud.pay.domain.repository.PayOrderRepository;
import com.framework.cloud.pay.domain.service.PayOrderService;
import lombok.AllArgsConstructor;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @ShardingSphereTransactionType(TransactionType.BASE)
    public boolean save(PayOrderDTO param) {
        PayOrder payOrder = new PayOrder();
        CopierUtil.copyProperties(param, payOrder);
        payOrder.setNum("num-" + RandomUtil.number(9));
        payOrder.setOrderNum("order-num-" + RandomUtil.number(9));
        payOrder.setOrderAmount(new BigDecimal(1));
        payOrder.setPayAmount(new BigDecimal(1));
        payOrder.setSuccessTime(LocalDateTime.now());
        payOrder.setStatus(PayStatus.ALREADY_PAY);
        payOrder.setType(PayModeType.WX_APP);
        payOrder.setModeId(1111111L);
        payOrder.setTradeId("11111111");
        payOrder.setTradeStatus("1");
        payOrder.setRemarks("2");
        return payOrderRepository.save(payOrder);
    }

}