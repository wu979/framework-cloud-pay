package com.framework.cloud.pay.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.pay.common.dto.order.PayOrderDTO;
import com.framework.cloud.pay.common.dto.order.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.order.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.order.PayOrderPageVO;
import com.framework.cloud.pay.domain.service.PayOrderService;
import com.framework.cloud.pay.infrastructure.mq.PayPublish;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 支付订单 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "支付订单")
@RestController
@RequestMapping(path = "/pay-order")
public class PayOrderController {

    @Resource
    private PayOrderService payOrderService;

    @Resource
    private PayPublish payPublish;

    @ApiOperation(value = "支付订单列表")
    @PostMapping(value = "/page")
    public Result<PageVO<PayOrderPageVO>> page(@ApiParam("条件") @RequestBody PayOrderPageDTO param) {
        return R.success(payOrderService.page(param));
    }

    @ApiOperation(value = "支付订单详情")
    @GetMapping(value = "/{id}/info")
    public Result<PayOrderInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        payPublish.publishPayOrder("1111111111");
        return R.success(payOrderService.info(id));
    }

    @ApiOperation(value = "支付订单新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("支付订单") @Valid @Validated(Save.class) @RequestBody PayOrderDTO param) {
        return R.success(payOrderService.save(param));
    }
}
