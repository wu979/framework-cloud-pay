package com.framework.cloud.pay.api.controller;

import com.framework.cloud.pay.domain.service.PayNotifyService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "")
@RestController
@RequestMapping(path = "/pay-notify")
public class PayNotifyController {

    @Resource
    private PayNotifyService payNotifyService;

}
