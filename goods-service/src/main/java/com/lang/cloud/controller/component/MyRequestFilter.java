package com.lang.cloud.controller.component;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String hello = request.getHeader("hello");
        System.out.println("过滤器执行");
        if (!StringUtils.isEmpty(hello)) {
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.getWriter().write("<html><body>没有登录哦</body></html>");
        }
    }
}
