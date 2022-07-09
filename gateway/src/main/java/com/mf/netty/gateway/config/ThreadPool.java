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
        init();
    }
    @PostConstruct
    public void init () {
        int cores = Runtime.getRuntime().availableProcessors();
        service = new ThreadPoolExecutor(cores, cores, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }
}
