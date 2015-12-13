package com.umasuo.weixin.common.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>class: AppConfig.java </p>
 * <p>description: com.umasuo.weixin.common.config </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午1:58:59
 */
@Component
@ConfigurationProperties(locations = "classpath:config/application.properties")
public class AppConfig {

    @NotNull
    @Valid
    @Value("${WEIXIN_APPID}")
    private String weixinAppid;
    @Value("${WEIXIN_APP_KEY}")
    private String weixinAppKey;
    @Value("${WEIXIN_TOKEN}")
    private String weixinToken;
    @Value("${AUTH_SERVER_URL}")
    private String authServerUrl;
    @Value("${WEIXIN_DEVICE_TYPE}")
    private String weixinDeviceType;
    public String getWeixinAppid() {
        return weixinAppid;
    }
    public void setWeixinAppid(String weixinAppid) {
        this.weixinAppid = weixinAppid;
    }
    public String getWeixinAppKey() {
        return weixinAppKey;
    }
    public void setWeixinAppKey(String weixinAppKey) {
        this.weixinAppKey = weixinAppKey;
    }
    public String getWeixinToken() {
        return weixinToken;
    }
    public void setWeixinToken(String weixinToken) {
        this.weixinToken = weixinToken;
    }
    public String getAuthServerUrl() {
        return authServerUrl;
    }
    public void setAuthServerUrl(String authServerUrl) {
        this.authServerUrl = authServerUrl;
    }
    public String getWeixinDeviceType() {
        return weixinDeviceType;
    }
    public void setWeixinDeviceType(String weixinDeviceType) {
        this.weixinDeviceType = weixinDeviceType;
    }


}