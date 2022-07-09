package com.mf.netty.gateway.inbound;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@ChannelHandler.Sharable
public class HttpTrackingHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpTrackingHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("HttpTrackingHandler ::");
//        super.channelRead(ctx,msg);
        ctx.fireChannelRead(msg);
    }
}
