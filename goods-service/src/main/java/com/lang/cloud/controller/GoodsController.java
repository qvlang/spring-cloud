package com.lang.cloud.controller;

import com.lang.cloud.model.Goods;
import com.lang.cloud.service.IGoodService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {
    @Autowired
    private IGoodService service;

    @PostMapping("/add")
    @HystrixCommand(fallbackMethod = "fail",commandProperties = {
            //默认20个;10s内请求数大于20个时就启动熔断器，当请求符合熔断条件时将触发getFallback()。
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value ="10" ),
            //请求错误率大于50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发getFallback()。
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "50"),
            //默认5秒;熔断多少秒后去尝试请求
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "5000")
    })
    public String addGoods(@RequestBody Goods goods) {
        int i = 10 / 0;
        boolean isSuccess = service.addGoods(goods);
        return isSuccess ? "00插入成功" : "00插入失败";
    }
    //方法的返回值和参数必须和HystrixCommand标注的方法一样
    public String fail(Goods goods) {
        return "服务失败";
    }

    @GetMapping("/{gid}")
//    @HystrixCommand(defaultFallback = "defaultFail")
    public Goods getGoodsById(@PathVariable Integer gid) {
        Goods goods = service.getGoods(gid);
        int i = 10 / 0;
        return goods;
    }
    //方法的返回值要相同 defaultFallback 不能有参数
    public Goods defaultFail() {
        Goods goods = new Goods();
        goods.setGNmae("我是兜底数据");
        return goods;
    }
}
