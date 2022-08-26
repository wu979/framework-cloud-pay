package com.framework.cloud.pay.domain.service;

import com.framework.cloud.pay.common.dto.order.PayNotifyDTO;
import com.framework.cloud.pay.common.vo.order.PayNotifyInfoVO;

/**
 *  服务层接口
 *
 * @author wusiwei
 */
public interface PayNotifyService {

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    PayNotifyInfoVO info(Long id);

    /**
     * 新增
     *
     * @param param 新增参数
     * @return bool
     */
    boolean save(PayNotifyDTO param);

}