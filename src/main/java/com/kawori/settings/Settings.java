package com.kawori.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "environments")
public class Settings {

    private final boolean DEBUG = true;
    private String token;
    @Value("${DISCORD_PREFIX}")
    private String prefix;
    @Value("${DISCORD_PREFIXROLE}")
    private String prefixrole;

    public String getToken() {
        return token;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPrefixRole() {
        return prefixrole;
    }
}
