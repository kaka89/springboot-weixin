package com.umasuo.weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umasuo.weixin.common.GlobalValues;
import com.umasuo.weixin.common.ReturnMessage;
import com.umasuo.weixin.common.config.AppConfig;

/**
 * 
 * <p>class: SettingsController.java </p>
 * <p>description: com.umasuo.weixin.controller </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:13:24
 */
@RestController
@RequestMapping(value = "/v1/system/settings")
public class SettingsController {
    private static Logger logger = LoggerFactory.getLogger(SettingsController.class);
    
    @Autowired
    AppConfig appConfig;
    
    /**
     * 该接口提供给其他支线程序获取accesstoken之用
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "")
    public String getAccessToken(HttpServletRequest request,HttpServletResponse response) {
        
//        String password = request.getParameter("umasuo");
//        JSONObject logs = new JSONObject();
//        logs.put("function", "GetAccessToken");
//        logs.put("password", password);
//        
//        if(password != null && password.equals("umasuo")){
//            ReturnMessage retMsg = new ReturnMessage(ReturnMessage.USER_NO_LOGIN_CODE,ReturnMessage.USER_NO_LOGIN_MESSAGE);
//            logs.put("retMsg", retMsg);
//            logger.info(logs.toString());
//            return retMsg.toString();
//        }
//        ReturnMessage retMsg = new ReturnMessage(ReturnMessage.SUCCESS_CODE,ReturnMessage.SUCCESS_MESSAGE);
//        JSONObject data = new JSONObject();
//        data.put("access_token", redis.get(GlobalValues.WEIXIN_ACCESS_TOKEN));
//        retMsg.setData(data);
//        
//        logs.put("retMsg", retMsg);
//        logger.info(logs.toString());
//        return retMsg.toString();
        return null;
    }
    
}
