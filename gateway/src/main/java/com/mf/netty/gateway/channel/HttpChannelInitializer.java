package com.mf.netty.gateway.channel;

import com.mf.netty.gateway.inbound.HttpInboundHandler;
import com.mf.netty.gateway.inbound.HttpTrackingHandler;
import com.mf.netty.gateway.outbound.HttpOutBoundHandler;
import com.mf.netty.gateway.outbound.TrackingOutBoundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HttpChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final HttpInboundHandler httpInboundHandler;

    private final HttpOutBoundHandler httpOutBoundHandler;

    private final HttpTrackingHandler httpTrackingHandler;

    private final TrackingOutBoundHandler trackingOutBoundHandler;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline= ch.pipeline();

        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(1024*1024));
        pipeline.addLast(httpTrackingHandler);
        pipeline.addLast(httpOutBoundHandler);
        pipeline.addLast(trackingOutBoundHandler);
        pipeline.addLast(httpInboundHandler);
    }
}
