package com.polis.config;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class Config {
    public String version = "1.0";
    public int endSessionId = -3;

    @Bean
    @ConditionalOnProperty(name = "spring.config.location", matchIfMissing = false)
    public PropertiesConfiguration propertiesConfiguration(@Value("${spring.config.location}") String path) throws Exception {
        String filePath = new File(path.substring("file:".length())).getCanonicalPath();
        PropertiesConfiguration configuration = new PropertiesConfiguration(new File(filePath));
        configuration.setReloadingStrategy(new FileChangedReloadingStrategy());
        return configuration;
    }
}
