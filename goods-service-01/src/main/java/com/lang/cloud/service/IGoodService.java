package com.lang.cloud.service;

import com.lang.cloud.model.Goods;

public interface IGoodService {
    //通过id查询货物
    Goods getGoods(Integer gid);

    //新增货物
    boolean addGoods(Goods goods);
}
