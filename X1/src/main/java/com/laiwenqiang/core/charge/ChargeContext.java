package com.laiwenqiang.core.charge;

import com.laiwenqiang.common.pipeline.context.AbstractEventContext;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lion
 * @date 2023/6/19 10:11
 */
public class ChargeContext extends AbstractEventContext<ChargeRequest, ChargeResponse> {
    @Getter
    @Setter
    private Car car;

    public ChargeContext(String bizCode, ChargeRequest request, ChargeResponse response) {
        super(bizCode, request, response);
    }
}
