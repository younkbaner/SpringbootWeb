package com.web.springbootweb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/16 23:29
 */

@Aspect
@Component
public class MyAnnotationAspect {


    //指定这个增强类对哪个注解生效
    @Pointcut("@annotation(com.web.springbootweb.aop.MyAnnotation)")
    public void pointcut(){

    }

    @Before(value = "pointcut()")
    public void before(){
        System.out.println("***********在被@MyAnnotation注解修饰的方法前面执行******************");
    }

    @After(value = "pointcut()")
    public void after(){
        System.out.println("***********在被@MyAnnotation注解修饰的方法后面面执行******************");
    }


    @Around(value="pointcut()")
    public Object point(ProceedingJoinPoint point) throws Throwable {


        Method method = ((MethodSignature) point.getSignature()).getMethod();
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if (annotation == null){
            System.out.println("直接跳过");
            return point.proceed();
        } else {
            System.out.println("获取的姓名:"+annotation.getName());
            System.out.println("获取的年龄:"+annotation.getAge());
            System.out.println("生效了");
            point.proceed();
        }


        return null;

    }
}
