package com.polis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

public class Config {
    public String version = "1.0";
    public int endSessionId = -3;
}
