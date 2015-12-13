package com.umasuo.weixin;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import com.umasuo.weixin.common.config.AppConfig;

/**
 *  the main class of this project like all spring boot projects
 * <p>class: Main.java </p>
 * <p>description: com.umasuo.weixin </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月13日 上午11:29:10
 */
@SpringBootApplication
@RestController
@EnableScheduling
@EnableConfigurationProperties(AppConfig.class)
public class Main extends DispatcherServlet {

    private static final long serialVersionUID = 6134298824290337045L;
    private static String id = UUID.randomUUID().toString();

    @RequestMapping(value = "/v1/appid/{adminid}", method = RequestMethod.GET, params = "type=test")
    public String home(@PathVariable String adminid, String password) {
        if(adminid.equals("umasuo") && password.equals("wakaka")){
            return id;
        }else{
            return "you got something wrong!";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
