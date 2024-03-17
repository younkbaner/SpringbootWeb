package com.web.springbootweb.eneity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/16 15:31
 */

@Component
public class BeamLifeCircleTest  implements BeanNameAware, BeanPostProcessor,InitializingBean, DisposableBean {

    private String name;

    private String age;

    public BeamLifeCircleTest() {
        System.out.println("bean生命周期第一步：实例化 bean 实例");

    }


    @Override
    public void setBeanName(String name) {
        System.out.println("bean生命周期第三步：检查是否实现 Aware 相关接口");
    }


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean生命周期第四步：检查是否实现 Aware 相关接口");
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean生命周期第五步：是否实现InitializingBean接口");

    }

    @PostConstruct
    public void initMethod(){
        System.out.println("bean生命周期第六步：是否配置自定义 init-method 方法");
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean生命周期第七步：是否配置自定义 init-method 方法");
        return bean;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("bean生命周期第八步：是否实现 Disposable接口");
    }

    @PreDestroy
    public void destoryMethod(){
        System.out.println("bean生命周期第九步：是否配置自定义 init-method 方法");
    }

}
