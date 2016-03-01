/*
 * Copyright (c) 2015-2016 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.umasuo.weixin.TestConfig;
import com.umasuo.weixin.routes.WeiXinRouting;

@RefreshScope
@RestController
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestConfig config;
    
    @RequestMapping(value = WeiXinRouting.TEST, method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestParam String id, @RequestParam String name) throws Exception {
        String msg = id + " got name:" + name + " message" + config.getMessage();
        logger.info(msg);
        return msg;
    }
}
