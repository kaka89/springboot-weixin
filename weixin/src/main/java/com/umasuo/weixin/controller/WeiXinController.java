package com.umasuo.weixin.controller;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umasuo.weixin.common.config.AppConfig;
import com.umasuo.weixin.common.util.ByteUtil;
import com.umasuo.weixin.common.weixin.message.WeiXinMessage;
import com.umasuo.weixin.common.weixin.message.WeiXinMessageUtil;


@RestController
@RequestMapping(value = "/weixin")
public class WeiXinController {
    private static Logger logger = LoggerFactory.getLogger(WeiXinController.class);

    @Autowired
    AppConfig appConfig;
    
//    @Autowired
//    DataService dataService;
//    @Autowired
//    RankService rankService;
//    @Autowired
//    CustomerService customerService;
//    @Autowired
//    SubscribeService subscribeService;
//    @Autowired
//    DeviceService deviceService;

    

    /**
     * 用于微信的接口验证
     * 本机测试：http://127.0.0.1:8080/v1/index?timestamp=1447717953&nonce=1971843426&signature=ff0ad10888718571721257a269af8642e629dca4&echostr=8558390795101437889
     * @param timestamp
     * @param nonce
     * @param signature
     * @param echostr
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String verify(String timestamp, String nonce, String signature,String echostr) {
        if (null==timestamp || null == nonce || null == signature || null== echostr ) {
            logger.info("weixin api verify failed. parameter is null");
            return "";
        }
        try {
            String[] arr = new String[] { timestamp, nonce,appConfig.getWeixinToken() };
            Arrays.sort(arr);
            String s = arr[0] + arr[1] + arr[2];
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(s.getBytes("utf-8"));
            String verifyString = ByteUtil.bytesToHexString(digest);
            if (signature.equals( verifyString.toLowerCase())) {
                logger.info("weixin api verify success. ");
                return echostr;
            }
        } catch (NoSuchAlgorithmException e) {
            logger.info("weixin api verify error. error message: "+ e.getMessage());
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            logger.info("weixin api verify error. error message: "+ e.getMessage());
            e.printStackTrace();
        }
        logger.info("weixin api verify failed. ");
        return "";
    }

    /**
     * 解析微信传过来的各种参数，这里应该可以用一个filter来过滤
     * @param request
     * @return
     */
    private WeiXinMessage checkIndexParams(HttpServletRequest request){
        try {
            Reader reader = request.getReader();
            char[] dataChar = new char[1000];
            reader.read(dataChar);
            String data = new String(dataChar);
            data = data.replace('\n', ' ').trim();
            if(data == null){
                return null;
            }
            
            WeiXinMessage msg = WeiXinMessageUtil.decodeMessage(data);
            
            if(msg==null){
                logger.error("weixin message is null. sessionid=" + request.getSession().getId() );
                return null;
            }
            
            return msg;
        } catch (IOException e) {
            logger.error("weixin parameters got error." + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 用于接受微信的消息回调
     * TODO: 加一个filter用于过滤无效请求
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void weixin(HttpServletRequest request,HttpServletResponse response ){
//        try {
//            //TODO: 以下功能可用异步方式处理，这里可以直接返回“success”
//            WeiXinMessage msg = checkIndexParams(request);
//            JSONObject logs = new JSONObject();
//            logs.put("WeiXinMessage", msg);
//            logs.put("sessionid", request.getSession().getId());
//            logger.info(logs.toString());
//            
//            if(null == msg){
//                response.getWriter().write("success");
//                return;
//            }else if(msg.MsgType.equals("device_event")){
//                //device event or message
//                if(msg.Event.equals("bind")){
//                    bindsService.bindDevice(msg,response);
//                }else if(msg.Event.equals("unbind")){
//                    bindsService.unbindDevice(msg, response);
//                }
//            }else if(msg.MsgType.equals("device_text")){
//                //这里用来响应设备的发送过来的消息（属于设备与服务器的自定义协定）
//                deviceService.answer(msg, response);
//                return;
//            }else if(msg.MsgType.equals("event") && msg.Event.equals("subscribe")){
//                subscribeService.subscribe(msg, response);
//                return;
//            }else if(msg.MsgType.equals("event") && msg.Event.equals("unsubscribe")){
//                subscribeService.unsubscribe(msg, response);
//                return;
//            }else if(msg.MsgType.equals("event") && msg.Event.equals("CLICK")){
//                if(msg.EventKey.equals("hm_current_steps")){
//                    dataService.showCurrentStep(msg,response);
//                }else if(msg.EventKey.equals("hm_wx_top")){
//                    rankService.showRank(msg,response);
//                }
//                return;
//            }else if(msg.MsgType.equals("text")){
//                customerService.answer(msg, response);
//                return;
//            }
//            
//            response.getWriter().write("success");
//            
//        } catch (Exception e) {
//            //catch all exceptions,and return a "success" to wechat-server
//            logger.error("weixin got an error." + e.getMessage());
//            logger.error(e.getMessage(), e);
//        }
    }
    
}
