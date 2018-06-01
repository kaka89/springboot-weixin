
package com.umasuo.wechat.infrastructure.messages.builders;


import com.umasuo.wechat.infrastructure.messages.AuthorizeDeviceMessage;
import com.umasuo.wechat.infrastructure.messages.DeviceQRCodeMessage;
import com.umasuo.wechat.infrastructure.messages.DeviceTextMessage;

public class WeChatDeviceMessageBuilder {

  public static DeviceTextMessage createTextMessage() {
    DeviceTextMessage message = new DeviceTextMessage("deviceType", "deviceId", "openId",
            "content");
    return message;
  }

  public static AuthorizeDeviceMessage createAuthorizeMessage() {
    AuthorizeDeviceMessage message = new AuthorizeDeviceMessage();
    message.setDeviceNumber("0");
    message.setOpType("opType");
    message.setProductId("productId");
    return message;
  }

  public static DeviceQRCodeMessage createQRcodeMessage() {
    DeviceQRCodeMessage message = new DeviceQRCodeMessage("deviceId");
    return message;
  }
}
