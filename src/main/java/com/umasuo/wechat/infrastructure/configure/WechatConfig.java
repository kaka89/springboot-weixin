package com.umasuo.wechat.infrastructure.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by umasuo on 2018/6/1.
 */
@Configuration
@Data
public class WechatConfig {

  public static final String WECHAT_MASTER_SERVICE_APP_REGION = "cn";

  @Value("${wechat.app.id}")
  private String wechatAppId;

  @Value("${wechat.app.secret}")
  private String wechatAppKey;

  @Value("${wechat.token}")
  private String wechatToken;

  @Value("${wechat.device.type}")
  private String wechatDeviceType;

  @Value("${wechat.app.name}")
  private String wechatAppName;

  @Value("${wechat.app.region}")
  private String wechatAppRegion;

  @Value("${wechat.master.address}")
  private String masterAddress;
}
