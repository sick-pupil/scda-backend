package com.scda.backend.scheduled;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.scda.backend.scheduled.mapper"})
public class ScdaBackendScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScdaBackendScheduledApplication.class, args);
    }

}
