
package com.umasuo.wechat.infrastructure.messages.builders;

import com.umasuo.wechat.infrastructure.messages.DeviceQRCode;

public class DeviceQRCodeBuilder {

  public static DeviceQRCode createDeviceQRCodeTestModel() {
    DeviceQRCode code = new DeviceQRCode();
    code.setToUserName("toUserName");
    code.setUserId("23456789");
    code.setTicket("this is ticket");
    return code;
  }
}
