package com.framework.cloud.pay.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信 请求支付返回体
 *
 * @author wusiwei
 */
@Data
public class PayWxResponse<T> implements Serializable {
    private static final long serialVersionUID = -7578160608362075741L;

    private String code;

    private String message;

    private T detail;

}
