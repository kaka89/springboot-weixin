
package com.umasuo.wechat.infrastructure.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * the data we send to wechat server when we want to create device qrcode
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DeviceQRCodeMessage {
  @JsonProperty("device_num")
  private String deviceNumber;
  @JsonProperty("device_id_list")
  private List<String> deviceIdList = new ArrayList<>();


  public DeviceQRCodeMessage(String deviceNum, List<String> deviceIdList) {
    this.deviceNumber = deviceNum;
    this.deviceIdList = deviceIdList;
  }

  public DeviceQRCodeMessage(String deviceId) {
    this.deviceNumber = "1";
    this.deviceIdList.add(deviceId);
  }

  public DeviceQRCodeMessage() {
  }

  public String build() throws JsonProcessingException {
    return this.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DeviceQRCodeMessage text = (DeviceQRCodeMessage) o;

    return Objects.equals(this.getDeviceNumber(), text.getDeviceNumber())
            && Objects.equals(this.getDeviceIdList(), text.getDeviceIdList());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getDeviceNumber(), this.getDeviceIdList());
  }
}