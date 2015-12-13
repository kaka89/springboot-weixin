package com.umasuo.weixin.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umasuo.weixin.common.config.AppConfig;
import com.umasuo.weixin.common.weixin.message.WeiXinMessage;
import com.umasuo.weixin.common.weixin.message.WeiXinResponse;
import com.umasuo.weixin.service.SubscribeService;

/**
 * 
 * <p>class: SubscribeServiceImpl.java </p>
 * <p>description: com.umasuo.weixin.service.impl </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:25:34
 */
@Service
public class SubscribeServiceImpl implements SubscribeService {
    private static Logger logger = LoggerFactory.getLogger(SubscribeServiceImpl.class);

//    @Autowired
//    WeiXinUserDao weixinUserDao;
    @Autowired
    AppConfig appConfig;

    @Override
    public void subscribe(WeiXinMessage msg, HttpServletResponse response) {
        
//        String openid = msg.FromUserName;
//        WeiXinUser user = weixinUserDao.getLatestUserByOpenid(appConfig.getFromRegion(), openid);
//        boolean isSuccessed = true;
//        if(user!=null && (int)user.getStatus() == -1){
//            user.setStatus((byte)'0');
//            isSuccessed = weixinUserDao.put(appConfig.getFromRegion(), user);
//        }
//        
//        JSONObject logs = new JSONObject();
//        logs.put("openid", msg.FromUserName);
//        logs.put("time", System.currentTimeMillis()/1000);
//        logs.put("event", "subscribe");
//        logs.put("result", isSuccessed);
//        try {
//            WeiXinResponse.TextResponse retMsg = new WeiXinResponse.TextResponse();
//            retMsg.Content = "AMAZFIT京东预约正式开启了！名额有限！预约地址：http://item.jd.com/1968013.html";
//            retMsg.ToUserName = msg.FromUserName;
//            retMsg.FromUserName = msg.ToUserName;
//            response.getWriter().write(retMsg.build());
//        } catch (IOException e) {
//            logs.put("result", "error");
//            logs.put("errMsg", e.getMessage());
//            logger.error(e.getMessage(), e);
//        }finally{
//            logger.info(logs.toString());
//        }
        
    }

    @Override
    public void unsubscribe(WeiXinMessage msg, HttpServletResponse response) {
        
//        String openid = msg.FromUserName;
//        WeiXinUser user = weixinUserDao.getLatestUserByOpenid(appConfig.getFromRegion(), openid);
//        boolean isSuccessed = true;
//        if(user!=null && (int)user.getStatus() == -1){
//            user.setStatus((byte)-1);
//            isSuccessed = weixinUserDao.put(appConfig.getFromRegion(), user);
//        }
//        
//        JSONObject logs = new JSONObject();
//        logs.put("openid", msg.FromUserName);
//        logs.put("time", System.currentTimeMillis()/1000);
//        logs.put("event", "unsubscribe");
//        logs.put("result", isSuccessed);
//        try {
//            WeiXinResponse.TextResponse retMsg = new WeiXinResponse.TextResponse();
//            retMsg.Content = "AMAZFIT京东预约正式开启了！名额有限！预约地址：http://item.jd.com/1968013.html";
//            retMsg.ToUserName = msg.FromUserName;
//            retMsg.FromUserName = msg.ToUserName;
//            response.getWriter().write(retMsg.build());
//        } catch (IOException e) {
//            logs.put("result", "error");
//            logs.put("errMsg", e.getMessage());
//            logger.error(e.getMessage(), e);
//        }finally{
//            logger.info(logs.toString());
//        }
    }
    
}
