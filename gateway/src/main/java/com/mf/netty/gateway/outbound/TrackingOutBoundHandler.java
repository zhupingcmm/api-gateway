package com.mf.netty.gateway.outbound;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@ChannelHandler.Sharable
public class TrackingOutBoundHandler extends ChannelOutboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(TrackingOutBoundHandler.class);
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        logger.info("TrackingOutBoundHandler:: ");
        ctx.write(msg);
    }
}
