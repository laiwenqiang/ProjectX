package com.laiwenqiang.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Lion
 * @date 2023/6/24 09:11
 */
@Component
@Data
@ConfigurationProperties(prefix = "charge")
public class ChargeConfigProperties {
    private Map<String, List<String>> handlers;
}
