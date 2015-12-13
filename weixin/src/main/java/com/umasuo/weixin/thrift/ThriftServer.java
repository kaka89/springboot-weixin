package com.umasuo.weixin.thrift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.umasuo.weixin.common.config.AppConfig;

/**
 * start the Thrift server
 * <p>class: ThriftServer.java </p>
 * <p>description: com.umasuo.weixin.thrift </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午3:24:27
 */
@Component
public class ThriftServer implements ApplicationListener<ContextRefreshedEvent>{
    
    @Autowired
    AppConfig appConfig;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // TODO Auto-generated method stub
    }
    
}
