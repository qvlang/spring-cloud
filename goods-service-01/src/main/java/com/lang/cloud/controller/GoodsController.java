package com.lang.cloud.controller;

import com.lang.cloud.model.Goods;
import com.lang.cloud.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {
    @Autowired
    private IGoodService service;

    @PostMapping("/add")
    public String addGoods(@RequestBody Goods goods) {
        boolean isSuccess = service.addGoods(goods);
        return isSuccess ? "01插入成功" : "01插入失败";
    }

    @GetMapping("/{gid}")
    public Goods getGoodsById(@PathVariable Integer gid) {
        Goods goods = service.getGoods(gid);
        return goods;
    }
}
