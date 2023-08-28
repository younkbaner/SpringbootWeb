package com.web.springbootweb.other.extendslearn;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/26 12:43
 */
@Component()
public class Father implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化时执行的方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁时执行的方法");
    }
}
