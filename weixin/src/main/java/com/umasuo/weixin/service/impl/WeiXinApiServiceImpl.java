package com.umasuo.weixin.service.impl;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umasuo.weixin.common.config.AppConfig;
import com.umasuo.weixin.common.util.GetPostUtil;
import com.umasuo.weixin.common.weixin.message.WeiXinRequest.AuthorizeDeviceRequest;
import com.umasuo.weixin.common.weixin.message.WeiXinRequest.DeviceQrcodeRequest;
import com.umasuo.weixin.common.weixin.message.WeiXinRequest.TextRequest;
import com.umasuo.weixin.service.WeiXinApiService;

/**
 * 
 * <p>class: WeiXinApiServiceImpl.java </p>
 * <p>description: com.umasuo.weixin.service.impl </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:25:46
 */
@Service
public class WeiXinApiServiceImpl implements WeiXinApiService{
    private static Logger logger = LoggerFactory.getLogger(WeiXinApiServiceImpl.class);
    private static final String  BASEURL = "https://api.weixin.qq.com";
    @Autowired
    private AppConfig appConfig;
    
    /**
     * get the token
     */
    @Override
    public String getToken(){
        //get from redis
//        String token= redis.get(GlobalValues.WEIXIN_ACCESS_TOKEN);
//        if(token != null && !token.equals("")){
//            return token;
//        }
//        //get from weixin
//        JSONObject logs = new JSONObject();
//        String url = "https://api.weixin.qq.com/cgi-bin/token";
//        String params = "grant_type=client_credential&appid="+appConfig.getWeixinAppid()+"&secret="+appConfig.getWeixinAppKey();
//        String result = GetPostUtil.sendGet(url, params);
//        JSONObject object = JSONObject.fromObject(result);
//        
//        if(null!= result){
//            token = object.get("access_token").toString();
//        }
//        //cache the token
//        redis.setex(GlobalValues.WEIXIN_ACCESS_TOKEN, 7000, token);
//        
//        logs.put("function", "GetWeiXinToken");
//        logs.put("url", url);
//        logs.put("params", params);
//        logs.put("result", result);
//        logs.put("time", System.currentTimeMillis()/1000);
//        logger.info(logs.toString());
//        return token;
        return "TpXRLyZPKzLtd5fttmRaaAx7ihPl-bGaZkXK3K5UXlc8EX-OvIPeb32XfProVfRSXD_aIt02ajiqIdHoBD7FC9ZCestxECXGIgnTdb9FVgoWHBcADAEPJ";
    }


    
    @Override
    public String sendTextToUser(TextRequest request) {
        String url = WeiXinApiServiceImpl.BASEURL + "cgi-bin/message/custom/send?access_token=" + this.getToken();
        String ret = GetPostUtil.sendPost(url, request.build(), false);
        return ret;
    }
    


    @Override
    public JSONObject getQrcode(DeviceQrcodeRequest request) {
        String url = WeiXinApiServiceImpl.BASEURL + "/device/create_qrcode?access_token=" + this.getToken() ;
        String ret = GetPostUtil.sendPost(url, request.build(), false);
        JSONObject obj = JSONObject.fromObject(ret);
        return obj;
    }


    @Override
    public JSONObject authorizeDevice(AuthorizeDeviceRequest request) {
        String url = WeiXinApiServiceImpl.BASEURL + "/device/authorize_device?access_token=" + this.getToken() ;
        String ret = GetPostUtil.sendPost(url, request.build(), false);
        JSONObject obj = JSONObject.fromObject(ret);
        return obj;
    }
    @Override
    public JSONObject getDeviceStatus(String deviceId) {
        
        String url = WeiXinApiServiceImpl.BASEURL + "/device/get_stat?access_token=" + this.getToken() + "&device_id="+deviceId;
        String ret = GetPostUtil.sendGet(url, "");
        JSONObject obj = JSONObject.fromObject(ret);
        return obj;
    }

    @Override
    public JSONObject getUserInfo(String openid) {
        String url = WeiXinApiServiceImpl.BASEURL + "/cgi-bin/user/info";
        StringBuilder params = new StringBuilder();
        params.append("access_token=").append(this.getToken());
        params.append("&openid=").append(openid);
        params.append("&lang=zh_CN");
        String ret = GetPostUtil.sendGet(url,  params.toString());
        JSONObject obj = JSONObject.fromObject(ret);
        return obj;
    }

    @Override
    public JSONObject setUserGroup(String openid, String groupId) {
        String url = WeiXinApiServiceImpl.BASEURL + "/cgi-bin/groups/members/update?access_token=" + this.getToken() ;
        JSONObject params = new JSONObject();
        params.put("openid", openid);
        params.put("to_groupid", groupId);
        String ret = GetPostUtil.sendPost(url, params.toString(), false);
        JSONObject obj = JSONObject.fromObject(ret);
        return obj;
    }

    @Override
    public JSONObject setUserRemark(String openid, String remark) {
        String url = WeiXinApiServiceImpl.BASEURL + "/cgi-bin/user/info/updateremark?access_token=" + this.getToken() ;
        JSONObject params = new JSONObject();
        params.put("openid", openid);
        params.put("remark", remark);
        String ret = GetPostUtil.sendPost(url, params.toString(), false);
        JSONObject obj = JSONObject.fromObject(ret);
        return obj;
    }
    
}
