package com.mf.netty.gateway.outbound;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@ChannelHandler.Sharable
public class HttpOutBoundHandler extends ChannelOutboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(HttpOutBoundHandler.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        logger.info("HttpOutBoundHandler::");
        FullHttpResponse response = (FullHttpResponse) msg;
        response.headers().set("mao", "zjx");
        ctx.write(msg);
    }
}
