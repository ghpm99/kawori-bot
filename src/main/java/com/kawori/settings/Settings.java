package com.kawori.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "environments")
public class Settings {

    private boolean debug;
    private String token;
    private String prefix;
    private String prefixrole;

}
