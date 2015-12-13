package com.umasuo.weixin.task.weixin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.umasuo.weixin.common.config.AppConfig;

/**
 * run once task
 * 
 * @author umasuo
 *
 */
@Component
public class WeiXinTaskStarter implements CommandLineRunner {

    @Autowired
    AppConfig appConfig;


    
    /**
     * start the processor. this method only run once,when the application start
     */
    @Override
    public void run(String... args) throws Exception {
    }
}
