package com.framework.cloud.pay.infrastructure.service.abs;

import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import com.framework.cloud.pay.common.vo.pay.PayWxVO;

/**
 * 微信支付 抽象
 *
 * @author wusiwei
 */
public abstract class AbstractPayWxService<R extends PayWxVO, T extends PayWxDTO, REQUESR, RESPONSE> extends AbstractPayService<R, T, REQUESR, RESPONSE> {

}
