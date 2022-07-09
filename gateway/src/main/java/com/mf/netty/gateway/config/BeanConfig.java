package com.mf.netty.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initConnectToZk")
    public ProxyServer proxyServer () {
        return new ProxyServer();
    }

    @Bean(initMethod = "initPool")
    public ThreadPool threadPool () {
        return new ThreadPool();
    }
}
