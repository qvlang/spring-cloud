package com.lang.cloud.controller.component;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * 加入权限拦截验证
 */


public class MyRequestInterceptor implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        String hello = webRequest.getHeader("hello");
        if (!StringUtils.isEmpty(hello)) System.out.println("你好 2020");
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        System.out.println("事情已办完");
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
