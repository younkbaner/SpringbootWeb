package com.web.springbootweb;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: ywz
 * @time: 2024/1/13 18:14
 */

@Configuration
public class ApolloKeyListener {

    @Bean
    public ApolloKeyListener setBean(){

        //通过切换 nameSpaces 名称，可以监听不同的命名空间
        Config config = ConfigService.getConfig("application");
        config.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent configChangeEvent) {
                System.out.println(configChangeEvent.changedKeys());
                for (String key :  configChangeEvent.changedKeys()){
                    ConfigChange change = configChangeEvent.getChange(key);
                    System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
                }
            }
        });
        System.out.println("测试一下");
        return new ApolloKeyListener();
    }
}
