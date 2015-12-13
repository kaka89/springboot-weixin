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
import com.umasuo.weixin.service.CustomerService;

/**
 * 
 * <p>class: CustomerServiceImpl.java </p>
 * <p>description: com.umasuo.weixin.service.impl </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:24:51
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
//    @Autowired
//    WeiXinUserDao weixinUserDao;
    @Autowired
    AppConfig appConfig;
    
    @Override
    public void answer(WeiXinMessage msg,HttpServletResponse response) {
//        String openid = msg.FromUserName;
//        String content = null;
//        JSONObject logs = new JSONObject();
//        logs.put("function", "Customer");
//        if(msg.Content.equals("#debug2023")){
//            WeiXinUser user = weixinUserDao.getLatestUserByOpenid(appConfig.getFromRegion(), openid);
//            logs.put("user", user);
//            if(null == user || !user.getOpenid().equals(openid)){
//                content = "您好，请从小米手环app中接入微信，再查看实时步数。";
//            }else{
//                content = "openid:" + user.getOpenid() + "\n";
//                content += "wxid:" + user.getWxid() + "\n";
//                content += "status:" + user.getStatus() + "\n";
//                content += "bindTime:" + user.getSubscribe_time();
//            }
//        }
//        
//        //step 1 根据关键字表自动回复，根据不同的关键词回复不同类型的消息
//        //step 2 过滤脏词 TODO
//        //step 3 转发给客服
//        try {
//            if(content != null){
//                WeiXinResponse.TextResponse retMsg = new WeiXinResponse.TextResponse();
//                retMsg.Content = content;
//                retMsg.ToUserName = msg.FromUserName;
//                retMsg.FromUserName = msg.ToUserName;
//                logs.put("answer", retMsg.build());
//                response.getWriter().write(retMsg.build());
//            }else{
//                WeiXinResponse.CustomerResponse retMsg = new WeiXinResponse.CustomerResponse(); 
//                retMsg.MsgType ="transfer_customer_service";//转发到客服
//                logs.put("answer", retMsg.build());
//                response.getWriter().write(retMsg.build());
//            }
//        } catch (IOException e) {
//            logs.put("result", "error");
//            logs.put("errMsg", e.getMessage());
//            logger.error(e.getMessage(),e);
//        }finally{
//            logger.info(logs.toString());
//        }
    }

}
