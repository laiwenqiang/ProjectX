package com.laiwenqiang.core.service;

import com.laiwenqiang.core.charge.ChargeRequest;
import com.laiwenqiang.core.charge.ChargeResponse;

/**
 * @author Lion
 * @date 2023/6/19 10:33
 */
public interface IChargeService {
    void handle(ChargeRequest chargeRequest, ChargeResponse chargeResponse);
}
