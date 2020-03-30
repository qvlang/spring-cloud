package com.lang.cloud.config;

import com.lang.cloud.component.MyBalanceRlue;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced  //开启负载均衡 同时对RestTemplate添加LoadBalancerInterceptor拦截器能够将服务名转成ip：port格式
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    //修改ribben负载均衡策略
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
