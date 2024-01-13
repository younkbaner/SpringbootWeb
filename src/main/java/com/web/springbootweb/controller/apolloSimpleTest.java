package com.web.springbootweb.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.core.dto.ApolloConfig;
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

    @PostMapping("/test1")
    public void test1() throws InterruptedException {
        System.out.println("test apollo properties get");
        Config config = ConfigService.getConfig("application");

        String someKey = "testValue";
        String someDefaultValue = "我是默认值";

        for (int i = 0; i < 10; i++) {
            Thread.sleep(10000);
            String value = config.getProperty(someKey, someDefaultValue);
            System.out.println("获取到配置值:"+value);
        }


    }
}
