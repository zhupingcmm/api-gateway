package com.mf.netty.gateway.route.impl;

import com.mf.netty.gateway.route.Router;

import java.util.Map;

public class RouterImpl implements Router {
    @Override
    public String route(Map<String, String> proxyServers) {

        String url = null;
        for (String key : proxyServers.keySet()) {
            url =  proxyServers.get(key);
            break;
        }
        return url;
    }
}
