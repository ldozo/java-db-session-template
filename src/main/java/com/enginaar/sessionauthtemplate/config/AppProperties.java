package com.enginaar.sessionauthtemplate.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppProperties {
    @Bean(name = "appMessages")
    @ConfigurationProperties(prefix = "app")
    Map<String, String> messages() {
        return new HashMap();
    }
}
