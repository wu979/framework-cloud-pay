package com.framework.cloud.pay.api.controller;

import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "权限")
@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping(value = "/{id}/t1")
    public Result<Long> test(@PathVariable("id") Long id) throws Exception {
        return R.success(id);
    }
}
