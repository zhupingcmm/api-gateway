package com.mf.netty.gateway.aop;

import com.mf.netty.gateway.config.ProxyServer;
import io.netty.handler.codec.http.FullHttpRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

@Aspect
public class InboundAspect {
    private static Logger logger = LoggerFactory.getLogger(InboundAspect.class);
    @Pointcut(value = "execution(* com.mf.netty.gateway.inbound.HttpInboundHandler.channelRead(..))")
    public void point() {}

    @Before(value = "point()")
    public void before(){
//        System.out.println("======> begin zClass dong");
    }

    @Around(value = "point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("======>around begin zClass dong");

        logger.debug("inbound filter aop");
        String[] names = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] values = joinPoint.getArgs();

        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], values[i]);
        }

        FullHttpRequest fullHttpRequest = (FullHttpRequest) map.get(names[1]);
        fullHttpRequest.headers().set("abc", "cmm");
        return joinPoint.proceed();
    }


    @After(value = "point()")
    public void after(){
//        System.out.println("======> after zClass dong");
    }
}
