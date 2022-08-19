package com.framework.cloud.pay.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.pay.common.dto.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.PayOrderPageVO;
import com.framework.cloud.pay.domain.entity.PayOrder;

import java.math.BigDecimal;

/**
 * 支付订单 数据层接口
 *
 * @author wusiwei
 */
public interface PayOrderRepository extends BaseRepository<PayOrder> {

    /**
     * 支付订单分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<PayOrderPageVO> page(PayOrderPageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    PayOrderInfoVO info(Long id);

    /**
     * 统计
     *
     * @return 金额
     */
    BigDecimal total();

}