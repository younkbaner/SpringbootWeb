package com.web.springbootweb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
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

        //获取目标方法的参数
        Object[] args = point.getArgs();
        System.out.println("目标方法参数如下:"+args);

        //获取目标方法签名
        Signature signature = point.getSignature();
        System.out.println("目标方法签名");

        //获取被增强的对象
        Object target = point.getTarget();
        System.out.println("被增强的对象:"+target);

        //获取被增强的方法上面的注解
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

        Object returnResult = null;

        if (annotation == null){
            //没有被注解修饰,name就可以不再执行下去了
            return null;
        } else {
            //如果使用了注解,此处可以获取注解中定义的属性值
            String name = annotation.getName();
            String age = annotation.getAge();
            System.out.println("获取到注解中属性:"+name+","+age);

            //此处是关键,上面只是增强的方法,还没有执行到目标方法,我们需要使用point去执行目标方法
            //这个returnResult就是目标方法执行后返回的
            try {

                System.out.println("我是环绕通知,在目标方法执行前执行的部分");

                returnResult = point.proceed(args);
                System.out.println("目标方法执行完毕,返回值:"+returnResult);

                System.out.println("我是环绕通知,在目标方法执行前执行的部分");

            }catch(Exception e){
                //这里可以捕获目标方法执行过程中抛出的异常
                System.out.println(e.getMessage());
            }


        }

        return returnResult;
    }
}
