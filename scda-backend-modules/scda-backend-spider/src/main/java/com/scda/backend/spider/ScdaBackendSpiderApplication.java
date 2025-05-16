package com.scda.backend.spider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.scda.backend.spider.mapper"})
public class ScdaBackendSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScdaBackendSpiderApplication.class, args);
    }

}
