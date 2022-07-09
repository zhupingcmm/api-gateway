package com.mf.server.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    @Setter
    @Getter
    private ZookeeperConfig zookeeperConfig = new ZookeeperConfig();

    @Data
    static class ZookeeperConfig {
        private String host = "localhost";
        private int port = 2181;
        private String protocol = "http";
    }
}
