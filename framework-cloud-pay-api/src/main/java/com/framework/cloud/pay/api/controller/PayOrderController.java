package com.framework.cloud.pay.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.pay.common.dto.PayOrderDTO;
import com.framework.cloud.pay.common.dto.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.PayOrderPageVO;
import com.framework.cloud.pay.domain.service.PayOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

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

    @ApiOperation(value = "支付订单列表")
    @PostMapping(value = "/page")
    public Result<PageVO<PayOrderPageVO>> page(@ApiParam("条件") @RequestBody PayOrderPageDTO param) {
        return R.success(payOrderService.page(param));
    }

    @ApiOperation(value = "支付订单详情")
    @GetMapping(value = "/{id}/info")
    public Result<PayOrderInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(payOrderService.info(id));
    }

    @ApiOperation(value = "支付订单统计")
    @GetMapping(value = "/total")
    public Result<BigDecimal> total() {
        return R.success(payOrderService.total());
    }

    @ApiOperation(value = "支付订单新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("支付订单") @Valid @Validated(Save.class) @RequestBody PayOrderDTO param) {
        return R.success(payOrderService.save(param));
    }

    @ApiOperation(value = "支付订单修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("支付订单") @Valid @Validated(Update.class) @RequestBody PayOrderDTO param) {
        return R.success(payOrderService.update(param));
    }

    @ApiOperation(value = "支付订单删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(payOrderService.removes(ids));
    }

}
