package com.framework.cloud.pay.domain.service;

import com.framework.cloud.pay.common.dto.pay.PayDTO;
import com.framework.cloud.pay.common.vo.pay.PayVO;

/**
 * 统一支付
 *
 * @author wusiwei
 */
public interface PayService<R extends PayVO, T extends PayDTO> {

    /**
     * 统一支付接口
     *
     * @param param 支付参数
     * @return 支付发起结果
     */
    R pay(T param);

}
