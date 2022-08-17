package com.framework.cloud.pay.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.pay.common.dto.PayOrderDTO;
import com.framework.cloud.pay.common.dto.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.PayOrderPageVO;

import java.util.List;

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

    /**
    * 修改
    *
    * @param param 修改参数
    * @return bool
    */
    boolean update(PayOrderDTO param);

    /**
     * 删除
     *
     * @param ids 主键
     * @return bool
     */
    boolean removes(List<Long> ids);

}