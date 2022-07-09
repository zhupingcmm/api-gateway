package com.mf.netty.gateway.inbound;

import com.mf.netty.gateway.config.Constants;
import com.mf.netty.gateway.config.ThreadPool;
import com.mf.netty.gateway.http.HttpCall;
import com.mf.netty.gateway.http.impl.OkHttp;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@ChannelHandler.Sharable
@RequiredArgsConstructor
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final ThreadPool threadPool;
    private final HttpCall httpCall;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
        String method = String.valueOf(fullHttpRequest.method());
        logger.info("start to request");
        switch (method) {
            case Constants.POST:
                threadPool.getService().submit(() -> httpCall.fetchPost(fullHttpRequest, ctx));
                break;
            case Constants.PATCH:
                threadPool.getService().submit(() -> httpCall.fetchPatch(fullHttpRequest, ctx));
                break;
            case Constants.DELETE:
                threadPool.getService().submit(() -> httpCall.fetchDelete(fullHttpRequest, ctx));
                break;
            default:
                threadPool.getService().submit(() -> httpCall.fetchGet(fullHttpRequest, ctx));
        }

    }
}
