package com.framework.cloud.pay.infrastructure.service;

import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.pay.common.dto.order.PayNotifyDTO;
import com.framework.cloud.pay.common.vo.order.PayNotifyInfoVO;
import com.framework.cloud.pay.domain.entity.PayNotify;
import com.framework.cloud.pay.domain.repository.PayNotifyRepository;
import com.framework.cloud.pay.domain.service.PayNotifyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 支付回调 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class PayNotifyServiceImpl implements PayNotifyService {

    private final PayNotifyRepository payNotifyRepository;

    @Override
    public PayNotifyInfoVO info(Long id) {
        return payNotifyRepository.info(id);
    }

    @Override
    public boolean save(PayNotifyDTO param) {
        PayNotify payNotify = new PayNotify();
        CopierUtil.copyProperties(param, payNotify);
        return payNotifyRepository.save(payNotify);
    }

}