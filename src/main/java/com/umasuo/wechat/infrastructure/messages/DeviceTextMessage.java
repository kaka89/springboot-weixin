
package com.umasuo.wechat.infrastructure.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

/**
 * send text message to device
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DeviceTextMessage {
  @JsonProperty("device_type")
  private String deviceType;
  @JsonProperty("device_id")
  private String deviceId;
  @JsonProperty("open_id")
  private String openId;
  @JsonProperty
  public String content;


  public DeviceTextMessage(String deviceType, String deviceId,
                           String openId, String content) {
    this.deviceType = deviceType;
    this.deviceId = deviceId;
    this.openId = openId;
    this.content = content;
  }

  public DeviceTextMessage() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DeviceTextMessage text = (DeviceTextMessage) o;

    return Objects.equals(this.getDeviceId(), text.getDeviceId())
            && Objects.equals(this.getOpenId(), text.getOpenId())
            && Objects.equals(this.getContent(), text.getContent())
            && Objects.equals(this.getDeviceType(), text.getDeviceType());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
            this.getDeviceId(),
            this.getOpenId(),
            this.getContent(),
            this.getDeviceType());
  }
}