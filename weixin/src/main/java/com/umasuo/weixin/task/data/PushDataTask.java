package com.umasuo.weixin.task.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.umasuo.weixin.common.config.AppConfig;

/**
 * Push data to other zone's server
 * <p>class: PushDataTask.java </p>
 * <p>description: com.umasuo.weixin.task.data </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:43:57
 */
@Component
public class PushDataTask implements CommandLineRunner {
    
    @Autowired
    AppConfig appConfig;
    
    @Override
    public void run(String... args) throws Exception {
       
        
    }

}
