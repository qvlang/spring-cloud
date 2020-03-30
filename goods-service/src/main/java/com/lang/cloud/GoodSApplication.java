package com.lang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.lang.cloud.mapper")
@EnableHystrix
public class GoodSApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodSApplication.class, args);
    }
}
