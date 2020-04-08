package com.lang.cloud.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Base64;

@Component
public class AuthorizedRequestFilter extends ZuulFilter {

    // 在进行Zuul过滤的时候可以设置其过滤执行的位置，那么此时有如下几种类型：
    // 1、pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
    // 2、route：在进行路由请求的时候被调用；
    // 3、post：在路由之后发送请求信息的时候被调用；
    // 4、error：出现错误之后进行调用
    @Override
    public String filterType() {
        return "pre";
    }

    // 设置优先级，数字越大优先级越低
    @Override
    public int filterOrder() {
        return 0;
    }

    // 该Filter是否要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 表示具体的过滤执行操作
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext(); // 获取当前请求的上下文
        //给请求添加标识
        String hello = "hello world 2020";
        byte[] encodeAuth = Base64.getEncoder().encode(hello.getBytes(Charset.forName("US-ASCII")));// 进行一个加密的处理
        context.addZuulRequestHeader("hello", new String(encodeAuth));
        return null;
    }
}
