package com.laiwenqiang.core.payment;

import com.laiwenqiang.common.pipeline.context.AbstractEventContext;

/**
 * @author Lion
 * @date 2023/6/23 20:51
 */
public class PaymentContext extends AbstractEventContext<PaymentRequest, PaymentResponse> {

    public PaymentContext(String bizCode, PaymentRequest request, PaymentResponse response) {
        super(bizCode, request, response);
    }


}
