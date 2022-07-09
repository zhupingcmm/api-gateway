package com.mf.netty.gateway.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class ThreadPool {
    @Getter
    private ThreadPoolExecutor service;

    public ThreadPool () {
        initPool();
    }
    public void initPool () {
        int cores = Runtime.getRuntime().availableProcessors();
        service = new ThreadPoolExecutor(cores, cores, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }
}
