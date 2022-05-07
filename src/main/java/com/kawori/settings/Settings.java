package com.kawori.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Settings {

    private final boolean DEBUG = true;
    @Value("${DISCORD_TOKEN}")
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
