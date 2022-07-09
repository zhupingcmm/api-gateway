package com.mf.netty.gateway.inbound;

import org.springframework.stereotype.Component;

@Component
public class HttpMock {
    public void read(){
        System.out.println("mock read");
    }
}
