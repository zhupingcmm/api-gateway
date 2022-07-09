package com.mf.netty.gateway.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpCall {
    void fetchPost(final FullHttpRequest request, final ChannelHandlerContext ctx);

    void fetchPatch(final FullHttpRequest request, final ChannelHandlerContext ctx);

    void fetchDelete(final FullHttpRequest request, final ChannelHandlerContext ctx);

    void fetchGet(final FullHttpRequest fullHttpRequest, final ChannelHandlerContext ctx);
}
