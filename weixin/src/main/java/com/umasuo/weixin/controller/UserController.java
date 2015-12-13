package com.umasuo.weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umasuo.weixin.common.ReturnMessage;
import com.umasuo.weixin.common.config.AppConfig;

@RestController
@RequestMapping(value = "/v1/info/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    
//    @Autowired
//    WeiXinUserDao weixinUser;
//
//    @Autowired
//    WeiXinApiService weixinApi;

    @Autowired
    AppConfig appConfig;

    @SuppressWarnings("finally")
    @RequestMapping(value = "")
    public String getUserInfo(HttpServletRequest request,HttpServletResponse response) {
        return null;
//        ReturnMessage retMsg = new ReturnMessage();
//        JSONObject logs = new JSONObject();
//        try {
//            String wxname = request.getParameter("wxname");
//            String userid = request.getParameter("userid");
//            if (wxname == null) {
//                wxname = "null";
//            }
//            
//            String wxid = wxname + "_" + userid;
//            JSONObject data = new JSONObject();
//            WeiXinUser user = weixinUser.getLatestUserByWxid(appConfig.getFromRegion(), wxid);
//            if (user != null) {
//                String openid = user.getOpenid();
//                JSONObject userinfo = weixinApi.getUserInfo(openid);
//                if (userinfo != null) {
//                    data.put("nickname", userinfo.get("nickname"));
//                    data.put("headimgurl", userinfo.get("headimgurl"));
//                    retMsg.setData(data);
//                    retMsg.setCode(ReturnMessage.SUCCESS_CODE);
//                    retMsg.setMessage(ReturnMessage.SUCCESS_MESSAGE);
//                    logs.put("result", "successed");
//                } else {
//                    logs.put("result", "failed");
//                    logs.put("userinfo", userinfo);
//                    retMsg.setCode(ReturnMessage.GET_WEIXIN_USER_INFO_CODE);
//                    retMsg.setMessage(ReturnMessage.GET_WEIXIN_USER_INFO_MESSAGE);
//                }
//            } else {
//                logs.put("result", "failed");
//                retMsg.setCode(ReturnMessage.GET_WEIXIN_USER_INFO_CODE);
//                retMsg.setMessage(ReturnMessage.GET_WEIXIN_USER_INFO_MESSAGE);
//            }
//
//            logs.put("wxname", wxname);
//            logs.put("userid", userid);
//            logs.put("api", "/v1/info/users GET");
//            logs.put("time", System.currentTimeMillis() / 1000);
//            logs.put("data", data);
//            
//        } catch (Exception e) {
//            retMsg.setCode(ReturnMessage.GET_WEIXIN_USER_INFO_CODE);
//            retMsg.setMessage(ReturnMessage.GET_WEIXIN_USER_INFO_MESSAGE);
//            logs.put("result", "error");
//            logs.put("errMsg", e.getMessage());
//            logger.error(e.getMessage(), e);
//            e.printStackTrace();
//        } finally{
//            logger.info(logs.toString());
//            return retMsg.toString();
//        }
    }

}
