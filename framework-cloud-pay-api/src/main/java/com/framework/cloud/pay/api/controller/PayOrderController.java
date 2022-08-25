package com.framework.cloud.pay.api.controller;
import cn.hutool.core.util.RandomUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.enums.pay.PayStatus;
import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.mybatis.utils.SnowflakeUtil;
import com.framework.cloud.pay.common.dto.order.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.order.PayOrderInfoVO;
import com.framework.cloud.pay.common.vo.order.PayOrderPageVO;
import com.framework.cloud.pay.domain.entity.PayNotify;
import com.framework.cloud.pay.domain.entity.PayOrder;
import com.framework.cloud.pay.domain.repository.PayNotifyRepository;
import com.framework.cloud.pay.domain.repository.PayOrderRepository;
import com.framework.cloud.pay.domain.service.PayOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private PayOrderRepository payOrderRepository;

    @Resource
    private PayNotifyRepository payNotifyRepository;

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

    @GetMapping(value = "/save")
    public Result<Boolean> save() {
        long id = SnowflakeUtil.nextId();
        PayOrder payOrder = new PayOrder();
        payOrder.setId(id);
        payOrder.setNum(RandomUtil.randomNumbers(5));
        payOrder.setOrderNum(RandomUtil.randomNumbers(5));
        payOrder.setOrderAmount(new BigDecimal("1"));
        payOrder.setPayAmount(new BigDecimal("1"));
        payOrder.setSuccessTime(LocalDateTime.now());
        payOrder.setStatus(PayStatus.ALREADY_PAY);
        payOrder.setType(PayModeType.WX_APP);
        payOrder.setTradeId(RandomUtil.randomNumbers(5));
        payOrder.setTradeStatus("1");
        payOrder.setRemarks("1");
        PayNotify payNotify = new PayNotify();
        payNotify.setPayOrderId(id);
        payNotify.setResource("1");
        payOrderRepository.save(payOrder);
        payNotifyRepository.save(payNotify);
        return R.success(true);
    }

    public static void main(String[] args) {

        System.out.println(1562674319194222592L % 10);
        System.out.println(2L % 10);

    }
}
