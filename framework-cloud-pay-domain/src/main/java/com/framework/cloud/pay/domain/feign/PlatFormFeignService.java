package com.framework.cloud.pay.domain.feign;

import com.framework.cloud.common.result.Result;
import com.framework.cloud.pay.common.rpc.PayChannelInfoVO;
import com.framework.cloud.pay.common.rpc.PayModeInfoVO;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 平台
 *
 * @author wusiwei
 */
@FeignClient(contextId = "PlatFormFeignService", value = "${client.platform}", decode404 = true)
public interface PlatFormFeignService {

    @GetMapping(value = "/pay-channel/{id}/info")
    Result<PayChannelInfoVO> channelInfo(@ApiParam("主键") @PathVariable("id") Long id);

    @GetMapping(value = "/pay-mode/{id}/info")
    Result<PayModeInfoVO> modeInfo(@ApiParam("主键") @PathVariable("id") Long id);
}
