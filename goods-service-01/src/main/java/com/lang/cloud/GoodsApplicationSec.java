package com.lang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.lang.cloud.mapper")
public class GoodsApplicationSec {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplicationSec.class, args);
    }
}
