package com.web.springbootweb.config;

import com.web.springbootweb.incerceptor.FirstInterceptor;
import com.web.springbootweb.incerceptor.SecondInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/12 15:48
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("配置拦截器>>>>>>>>>>>>>");
        //拦截器的注册顺序决定拦截器的执行顺序
        registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/*");
    }
}
