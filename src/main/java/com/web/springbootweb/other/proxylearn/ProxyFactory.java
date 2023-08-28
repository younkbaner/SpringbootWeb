package com.web.springbootweb.other.proxylearn;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.boot.autoconfigure.sendgrid.SendGridProperties;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 使用单例模式, 创建的一个代理工具类, 对外提供两个方法:jdk动态代理,cglib动态代理
 * @author: ywz
 * @time: 2023/8/28 10:25
 */
public class ProxyFactory {

    /**
     * @author 应癫
     * <p>
     * <p>
     * 代理对象工厂：生成代理对象的
     */


    //因为使用的是单例模式,需要将构造器私有化,让外界无法通过 new ProxyFactory() 再创建代理工厂对象
    private ProxyFactory() {

    }

    //这是一个被final static 修饰的静态属性,在ProxyFactory类加载的时候,这行代码就会被执行,将proxyFactory属性指向了一个ProxyFactory类的实力对象对象
    //经过final修饰之后,外界无法再改变 proxyFactory 的引用,也就是说,外界不能再给proxyFactory赋值,或者变更所指向的对象
    private static final ProxyFactory proxyFactory = new ProxyFactory();


    //提供一个外部获取工厂实例的方法,让外界可以直接使用这个 proxyFactory 实例
    public static ProxyFactory getInstance() {
        return proxyFactory;
    }


    /**
     * Jdk动态代理
     *
     * @param obj 委托对象
     * @return 代理对象
     */
    public Object getJdkProxy(Object obj) {

        ClassLoader classLoader = obj.getClass().getClassLoader();

        Class<?>[] interfaces = obj.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {

                //执行目标方法前的前代理增强逻辑
                System.out.println("Jdk代理,目标方法执行前执行,可以增加增强逻辑");
                long start = System.currentTimeMillis();
                System.out.println(start);

                //执行代理方法,获取执行结果
                Object result = method.invoke(obj, objects);

                //执行目标方法后的代理后增强逻辑
                System.out.println("Jdk代理,目标方法执行前执行,可以增加增强逻辑");
                long end = System.currentTimeMillis();
                System.out.println(end);

                //代理完成,返回执行结果
                return result;

            }
        };


         return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        // 获取代理对象
        //return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
        //        new InvocationHandler() {
        //            @Override
        //            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //                Object result = null;
        //
        //                // 写增强逻辑
        //                System.out.println("中介（代理）收取服务费3000元");
        //                // 调用原有业务逻辑
        //                result = method.invoke(obj, args);
        //
        //                System.out.println("客户信息卖了3毛钱");
        //
        //                return result;
        //            }
        //        });
    }


    /**
     * 使用cglib动态代理生成代理对象
     *
     * @param obj 委托对象
     * @return
     */
    public Object getCglibProxy(Object obj) {

        //Step 1:获取被代理类的类名
        Class<?> proxyClass = obj.getClass();

        //Step 2:主要的方法拦截类,需要我们去实现,实现intercept方法时,可以编写我们自己的业务逻辑
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                //执行目标方法前的前代理增强逻辑
                System.out.println("Cglib代理,目标方法执行前执行,可以增加增强逻辑");
                long start = System.currentTimeMillis();
                System.out.println(start);

                //执行代理方法,获取执行结果
                Object result = method.invoke(obj, objects);

                //执行目标方法后的代理后增强逻辑
                System.out.println("Cglib代理,目标方法执行前执行,可以增加增强逻辑");
                long end = System.currentTimeMillis();
                System.out.println(end);

                //代理完成,返回执行结果
                return result;
            }
        };

        //主要的增强类
        Enhancer enhancer = new Enhancer();

        //获取生成的代理类
        Object proxy = enhancer.create(proxyClass, methodInterceptor);

        //返回代理类
        return proxy;

        //课程老师讲的方法
        //return Enhancer.create(obj.getClass(), new MethodInterceptor() {
        //    @Override
        //    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //        Object result = null;
        //        System.out.println("Cglib代理,目标方法执行前执行,可以增加增强逻辑");
        //        result = method.invoke(obj, objects);
        //        System.out.println("Cglib代理,目标方法执行前执行,可以增加增强逻辑");
        //        return result;
        //    }
        //});
    }
}

