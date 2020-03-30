package com.lang.cloud.controller;

import com.lang.cloud.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    //使用restTemplate直接调用服务
    private final String GOODS_USER_PREFIX = "http://GOODS-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{gid}")
    public String tGet(@PathVariable Integer gid) {
        Goods goods = restTemplate.getForObject(GOODS_USER_PREFIX + "/{1}", Goods.class, gid);
        return goods.toString();
    }

    @GetMapping("/add")
    public String tAdd() {
        Goods goods = new Goods();
        goods.setGClass("汽车");
        goods.setGCount(1);
        goods.setGNmae("宝马");
        goods.setGOwnid(3);
        String s = restTemplate.postForObject(GOODS_USER_PREFIX + "/add", goods, String.class);
        return s;
    }

}
