package com.umasuo.weixin.service;

import net.sf.json.JSONObject;

import com.umasuo.weixin.common.weixin.message.WeiXinRequest.AuthorizeDeviceRequest;
import com.umasuo.weixin.common.weixin.message.WeiXinRequest.DeviceQrcodeRequest;
import com.umasuo.weixin.common.weixin.message.WeiXinRequest.TextRequest;

/**
 * 
 * <p>class: WeiXinApiService.java </p>
 * <p>description: com.umasuo.weixin.service </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:23:16
 */
public interface WeiXinApiService {

    
    public String getToken();
    
    public String sendTextToUser(TextRequest request);
    public JSONObject getDeviceStatus(String deviceId);
    public JSONObject getQrcode(DeviceQrcodeRequest request);
    public JSONObject getUserInfo(String openid);
    public JSONObject setUserGroup(String openid, String groupId);
    public JSONObject setUserRemark(String openid, String remark);
    public JSONObject authorizeDevice(AuthorizeDeviceRequest request);
}
