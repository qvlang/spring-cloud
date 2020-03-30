package com.lang.cloud.component;

import com.lang.cloud.model.Goods;
import com.lang.cloud.service.IGoodsService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component //放入spring容器
public class GoodsServiceFallbackFactory implements FallbackFactory<IGoodsService> {
    @Override
    public IGoodsService create(Throwable throwable) {
        return new IGoodsService() {
            @Override
            public String addGoods(Goods goods) {
                return "feign 调用服务时服务出错";
            }

            @Override
            public Goods GoodsById(Integer gid) {
                Goods goods = new Goods();
                goods.setGNmae("feign");
                goods.setGClass("兜底数据");
                return goods;
            }
        };
    }
}
