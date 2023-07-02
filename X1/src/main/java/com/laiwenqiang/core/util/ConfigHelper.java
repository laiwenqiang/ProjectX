package com.laiwenqiang.core.util;

import com.laiwenqiang.core.config.ChargeConfigProperties;
import com.laiwenqiang.core.config.PaymentConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lion
 * @date 2023/6/24 09:14
 */
@Component
public class ConfigHelper {
    @Autowired
    private ChargeConfigProperties chargeConfigProperties;
    @Autowired
    private PaymentConfigProperties paymentConfigProperties;

    public Map<String, List<String>> getHandlers() {
        Map<String, List<String>> result = new HashMap<>();
        result.putAll(chargeConfigProperties.getHandlers());
        result.putAll(paymentConfigProperties.getHandlers());
        return result;
    }
}
