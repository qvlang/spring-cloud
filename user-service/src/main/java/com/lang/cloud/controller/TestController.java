package com.lang.cloud.controller;

import com.lang.cloud.model.Goods;
import com.lang.cloud.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/add")
    public String add() {
        Goods goods = new Goods();
        goods.setGNmae("feign");
        goods.setGClass("A类");
        return goodsService.addGoods(goods);
    }

    @GetMapping("/{id}")
    public Goods get(@PathVariable Integer id) {
        return goodsService.GoodsById(id);
    }
}
