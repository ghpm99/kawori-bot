package com.kawori.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "environments")
public class Settings {

    private final boolean DEBUG = true;
    private String token;
    private String prefix;
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
