package com.framework.cloud.pay.infrastructure.service.wx;
import com.framework.cloud.enums.pay.PayStatus;

import com.framework.cloud.pay.common.dto.pay.wx.PayWxAppDTO;
import com.framework.cloud.pay.common.model.request.PayWxAppRequest;
import com.framework.cloud.pay.common.model.response.PayWxAppResponse;
import com.framework.cloud.pay.common.vo.pay.wx.PayWxAppVO;
import com.framework.cloud.pay.infrastructure.service.abs.AbstractPayWxService;
import org.springframework.stereotype.Service;

/**
 * 微信唤醒支付
 *
 * @author wusiwei
 */
@Service("WX_APP")
public class PayWxAppServiceImpl extends AbstractPayWxService<PayWxAppVO, PayWxAppDTO, PayWxAppRequest, PayWxAppResponse> {

    @Override
    protected PayWxAppVO result() {
        PayWxAppVO vo = new PayWxAppVO();
        vo.setOrderNo("1");
        vo.setPayNo("2");
        vo.setStatus(PayStatus.WAIT_PAY);
        return vo;
    }
}
