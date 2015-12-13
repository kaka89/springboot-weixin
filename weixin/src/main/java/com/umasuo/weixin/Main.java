package com.umasuo.weixin;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@RestController
@EnableScheduling
// @EnableConfigurationProperties(AppConfig.class)
public class Main extends DispatcherServlet {
    private static final long serialVersionUID = 1L;

    private static String id = UUID.randomUUID().toString();

    @RequestMapping(value = "/v1/appid/{userid}", method = RequestMethod.GET, params = "type=test")
    public String home(@PathVariable String userid, String password) {
        if(userid.equals("umasuo") && password.equals("wakaka")){
            return id;
        }else{
            return "you got something wrong!";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
