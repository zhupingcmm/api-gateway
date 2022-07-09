package com.mf.netty.gateway.config;

import com.mf.netty.gateway.inbound.HttpInboundHandler;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
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
