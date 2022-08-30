package com.framework.cloud.pay.common.dto.pay;

import com.framework.cloud.enums.platform.PayChannelType;
import lombok.*;
import lombok.experimental.FieldNameConstants;

/**
 * 银联 父类
 *
 * @author wusiwei
 */
@Setter
@Getter
@FieldNameConstants
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public abstract class PayYlDTO extends PayDTO {
    private static final long serialVersionUID = -3618488446155651478L;

    @Override
    public PayChannelType getPayChannelType() {
        return PayChannelType.YL;
    }
}
