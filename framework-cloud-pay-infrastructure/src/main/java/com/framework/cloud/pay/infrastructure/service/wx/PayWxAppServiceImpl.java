package com.framework.cloud.pay.infrastructure.service.wx;
import com.framework.cloud.common.result.ResultApi;
import com.framework.cloud.enums.pay.PayStatus;
import com.framework.cloud.pay.common.dto.pay.wx.PayWxAppDTO;
import com.framework.cloud.pay.common.model.request.PayWxAppRequest;
import com.framework.cloud.pay.common.model.response.PayWxAppResponse;
import com.framework.cloud.pay.common.rpc.PayChannelInfoVO;
import com.framework.cloud.pay.common.rpc.PayModeInfoVO;
import com.framework.cloud.pay.common.vo.pay.wx.PayWxAppVO;
import com.framework.cloud.pay.domain.entity.PayOrder;
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
    protected PayWxAppRequest request(PayModeInfoVO modeInfo, PayWxAppDTO param) {
        return null;
    }

    @Override
    protected ResultApi<PayWxAppResponse> tradePay(PayChannelInfoVO channelInfo, PayWxAppRequest payWxAppRequest) throws Exception {
        return null;
    }

    @Override
    protected PayOrder payOrder(PayWxAppRequest payWxAppRequest, PayWxAppResponse payWxAppResponse) {
        return null;
    }

    @Override
    protected PayWxAppVO result(String orderNo, String payNo, PayStatus status) {
        return null;
    }
}
