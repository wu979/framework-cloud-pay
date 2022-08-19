package com.framework.cloud.pay.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.mybatis.annotation.LongToBigDecimal;
import com.framework.cloud.pay.common.dto.PayOrderPageDTO;
import com.framework.cloud.pay.common.vo.PayOrderPageVO;
import com.framework.cloud.pay.domain.entity.PayOrder;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 支付订单 数据库接口
 *
 * @author wusiwei
 */
public interface PayOrderMapper extends BaseMapper<PayOrder> {

    IPage<PayOrderPageVO> page(@Param("pg") Page<PayOrderPageVO> page, @Param("param") PayOrderPageDTO param);

    BigDecimal total();

}