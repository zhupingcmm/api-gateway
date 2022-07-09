package com.mf.server.config;

import com.mf.common.base.ZkSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class ZkRegister {

    private final AppConfig appConfig;

    @Value("${spring.application.name}")
    private String applicationName;


    @PostConstruct
    private void register(){
        String zkUrl = appConfig.getZookeeperConfig().getHost() + ":" + appConfig.getZookeeperConfig().getPort();

        String zkRootServer = "/" + applicationName;
        ZkClient zkClient = new ZkClient(zkUrl);
        zkClient.setZkSerializer(new ZkSerializer());

        if (!zkClient.exists(zkRootServer)) {
            zkClient.createPersistent(zkRootServer);
        }

        int num = new Random().nextInt(10);
        zkClient.createEphemeral(zkRootServer + "/" + num, "http://localhost:8889");
        log.info("Success to register application to zk server.");

    }
}
