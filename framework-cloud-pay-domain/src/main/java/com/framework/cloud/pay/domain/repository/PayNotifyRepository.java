package com.framework.cloud.pay.domain.repository;

import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.pay.common.vo.order.PayNotifyInfoVO;
import com.framework.cloud.pay.domain.entity.PayNotify;

/**
 * 支付回调 数据层接口
 *
 * @author wusiwei
 */
public interface PayNotifyRepository extends BaseRepository<PayNotify> {

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    PayNotifyInfoVO info(Long id);

}