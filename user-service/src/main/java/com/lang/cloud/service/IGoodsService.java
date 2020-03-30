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

@FeignClient(name = "GOODS-SERVICE", fallbackFactory = GoodsServiceFallbackFactory.class)
public interface IGoodsService {
    //新增货物
    @PostMapping("/add")
    String addGoods(@RequestBody Goods goods);

    //通过id获取货物
    @GetMapping("/{gid}")
    Goods GoodsById(@PathVariable Integer gid);
}
