package com.lang.cloud.service;

import com.lang.cloud.component.GoodsServiceFallbackFactory;
import com.lang.cloud.model.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//使用feign调用服务
//feign 整合了hystrix
//使用zuul代理了访问微服务 要为请求增加认证需要让请求走zuul 所以feign的调用地址需要走zuul代理地址
@FeignClient(name = "GATEWAY-ZUUL/GOODS-SERVICE", fallbackFactory = GoodsServiceFallbackFactory.class)
public interface IGoodsService {
    //新增货物
    @PostMapping("/add")
    String addGoods(@RequestBody Goods goods);

    //通过id获取货物
    @GetMapping("/{gid}")
    Goods GoodsById(@PathVariable Integer gid);
}
