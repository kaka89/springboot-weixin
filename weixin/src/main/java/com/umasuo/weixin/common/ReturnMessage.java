package com.umasuo.weixin.common;

import net.sf.json.JSONObject;

public class ReturnMessage {
    private int code;
    private String message;
    private Object data;
    public ReturnMessage(){
    }
    public ReturnMessage(int code,String message){
        this.code = code;
        this.message = message;
    }
    
    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        if(null == data){
            return "";
        }
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    
    
    public static int SUCCESS_CODE = 1;
    public static String SUCCESS_MESSAGE = "success";
    
    public static int USER_NO_LOGIN_CODE = 0;
    public static String USER_NO_LOGIN_MESSAGE = "user has not logined";
    
    
    public static int USER_HAS_NO_DEVICE_CODE = -1009;
    public static String USER_HAS_NO_DEVICE_MESSAGE = "user do not have a device";
    public static int GET_DEVICE_STATUS_FORM_WEIXIN_FAILED_CODE = -1010;
    public static String GET_DEVICE_STATUS_FORM_WEIXIN_FAILED_MESSAGE = "get device status from weixin failed";
    public static int AUTHORIZE_DEVICE_FAILED_CODE = -1011;
    public static String AUTHORIZE_DEVICE_FAILED_MESSAGE = "authrize deivce failed";
    public static int CREATE_QRCODE_FAILED_CODE = -1012;
    public static String CREATE_QRCODE_FAILED_MESSAGE = "create qrcode failed";
    public static int UNBIND_WEIXIN_FAILED_CODE = -1013;
    public static String UNBIND_WEIXIN_FAILED_MESSAGE = "unbind weixin failed";
    public static int GET_WEIXIN_USER_INFO_CODE = -1014;
    public static String GET_WEIXIN_USER_INFO_MESSAGE = "get user's weixin info failed";
}


