package com.framework.cloud.pay.api.controller;

import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.common.utils.FastJsonUtil;
import com.framework.cloud.pay.common.dto.pay.PayWxDTO;
import com.framework.cloud.pay.common.dto.pay.wx.PayWxAppDTO;
import com.framework.cloud.pay.common.vo.pay.PayWxVO;
import com.framework.cloud.pay.common.vo.pay.wx.PayWxAppVO;
import com.framework.cloud.pay.infrastructure.strategy.PayStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 微信支付 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "微信支付")
@RestController
@RequestMapping(path = "/payment/wx")
public class PayWxController {

    @Resource
    private PayStrategy<PayWxVO, PayWxDTO> payStrategy;

    @ApiOperation("微信唤醒支付")
    @PostMapping("/app")
    public Result<PayWxAppVO> appPay(@ApiParam("支付参数") @Valid @RequestBody PayWxAppDTO param) {
        PayWxVO payWxVO = payStrategy.payService(param);
        return R.success(FastJsonUtil.toJavaObject(payWxVO, PayWxAppVO.class));
    }

}
