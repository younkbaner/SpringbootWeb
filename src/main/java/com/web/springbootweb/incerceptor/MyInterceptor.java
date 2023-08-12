package com.web.springbootweb.incerceptor;

import com.sun.corba.se.impl.protocol.giopmsgheaders.TargetAddress;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/12 15:44
 */
public class MyInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("自定义的拦截器的preHandler方法执行了");
        System.out.println(request.getRequestURI());
        System.out.println(request.getRemoteAddr());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("自定义拦截器的postHandler方法执行了");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("自定义烂机器的afterCompletion方法执行了");
    }
}
