package com.mf.netty.gateway;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NettyGateway {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
