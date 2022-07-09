package com.mf.netty.gateway.route;

import java.util.Map;

public interface Router {
    String route(Map<String, String> proxyServers);
}
