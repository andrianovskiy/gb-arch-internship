package com.arch.intern.crm.backend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Configuration
@ConfigurationProperties(prefix = "server")
@Setter
@Getter
public class ServerConfig {
    private String host;
    private String port;
}
