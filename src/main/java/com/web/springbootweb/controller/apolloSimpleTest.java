package com.web.springbootweb.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ywz
 * @time: 2023/12/4 00:27
 */

@RestController
public class apolloSimpleTest {

    @Value("${testValue222:100}")
    private String testValue222;

    @ApolloConfig
    Config configService;

    @PostMapping("/test1")
    public void test1() throws InterruptedException {
        System.out.println("test apollo properties get");
        Config config = ConfigService.getConfig("application");

        String someKey = "testValue";
        String someDefaultValue = "我是默认值";

        System.out.println("testValue222:"+testValue222);

        String value = config.getProperty(someKey, someDefaultValue);
    }

    @PostMapping("test2")
    public void test2(){

        //获取不同的命名空间的 key 时，只需要传入不同的 nameSpaces 名称即可
        Config aSwitch = ConfigService.getConfig("switch");
        String defaultValue = aSwitch.getProperty("redisson.password", "defaultValue");
        System.out.println(defaultValue);
    }

    @PostMapping("test3")
    public void test3(){
        String testValue = configService.getProperty("testValue", "999999");
        System.out.println(testValue);
    }
}
