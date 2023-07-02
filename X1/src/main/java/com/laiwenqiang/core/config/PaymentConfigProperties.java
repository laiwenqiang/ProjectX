package com.laiwenqiang.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Lion
 * @date 2023/6/24 09:12
 */
@Component
@Data
@ConfigurationProperties(prefix = "payment")
public class PaymentConfigProperties {
    private Map<String, List<String>> handlers;
}
