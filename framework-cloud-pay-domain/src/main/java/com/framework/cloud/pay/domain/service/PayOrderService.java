package com.framework.cloud.pay.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.pay.common.dto.order.PayOrderDTO;
import com.framework.cloud.pay.common.dto.order.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.order.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.order.PayOrderPageVO;

/**
 * 支付订单 服务层接口
 *
 * @author wusiwei
 */
public interface PayOrderService {
    /**
     * 支付订单 分页
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
     * 新增
     *
     * @param param 新增参数
     * @return bool
     */
    boolean save(PayOrderDTO param);

}