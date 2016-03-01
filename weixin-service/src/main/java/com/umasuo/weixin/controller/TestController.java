/*
 * Copyright (c) 2015-2016 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import com.umasuo.weixin.routes.WeiXinRouting;

@RestController
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @ApiOperation(value = "Get Sony's AGps files")
    @RequestMapping(value = WeiXinRouting.TEST, method = RequestMethod.GET)
    @ResponseBody
    public String list(@RequestParam String id, @RequestParam String name) throws Exception {
        logger.info("we got id:" + id + " name:" + name);
        return id + " got name:" + name;
    }
}
