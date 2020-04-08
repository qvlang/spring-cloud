package com.lang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.lang.cloud.mapper")
@EnableHystrix
@ServletComponentScan(basePackages = "com.lang.cloud.controller.component") //扫描过滤器所在包
public class GoodSApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodSApplication.class, args);
    }
}
