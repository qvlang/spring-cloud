package com.lang.cloud.service.impl;

import com.lang.cloud.mapper.IGoodsMapper;
import com.lang.cloud.model.Goods;
import com.lang.cloud.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements IGoodService {
    @Autowired
    private IGoodsMapper mapper;

    @Override
    public Goods getGoods(Integer gid) {
        Goods goods = mapper.selectByPrimaryKey(gid);
        return goods;
    }

    @Override
    public boolean addGoods(Goods goods) {
        int affectRow = mapper.insertSelective(goods);
        return affectRow > 0;
    }
}
