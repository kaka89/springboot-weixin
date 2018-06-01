
package com.umasuo.wechat.infrastructure.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给设备授权时的请求对象
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AuthorizeDeviceMessage {
  @JsonProperty("device_num")
  public String deviceNumber;

  @JsonProperty("device_list")
  public List<Device> deviceList = new ArrayList<>();

  @JsonProperty("op_type")
  public String opType;

  @JsonProperty("product_id")
  public String productId;

  public AuthorizeDeviceMessage() {
  }

  public AuthorizeDeviceMessage(String number, List<Device> devices, String type) {
    this.deviceNumber = number;
    this.deviceList = devices;
    this.opType = type;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class Device {
    @JsonProperty("id")
    private String id;

    @JsonProperty("mac")
    private String mac;

    @JsonProperty("connect_protocol")
    private String connectProtocol;

    @JsonProperty("auth_key")
    private String authKey;

    @JsonProperty("close_strategy")
    private String closeStrategy;

    @JsonProperty("conn_strategy")
    private String connStrategy;

    @JsonProperty("crypt_method")
    private String cryptMethod;

    @JsonProperty("auth_ver")
    private String authVer;

    @JsonProperty("manu_mac_pos")
    private String manuMacPos;

    @JsonProperty("ser_mac_pos")
    private String serMacPos;

    @JsonProperty("ble_simple_protocol")
    private String bleSimpleProtocol;

    public Device() {
    }

    public Device(String id,
                  String mac,
                  String connectProtocol,
                  String authKey,
                  String closeStrategy,
                  String connStrategy,
                  String cryptMethod,
                  String authVer,
                  String manuMacPos,
                  String serMacPos,
                  String bleSimpleProtocol) {
      this.id = id;
      this.mac = mac;
      this.connectProtocol = connectProtocol;
      this.authKey = authKey;
      this.closeStrategy = closeStrategy;
      this.connStrategy = connStrategy;
      this.cryptMethod = cryptMethod;
      this.authVer = authVer;
      this.manuMacPos = manuMacPos;
      this.serMacPos = serMacPos;
      this.bleSimpleProtocol = bleSimpleProtocol;
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AuthorizeDeviceMessage text = (AuthorizeDeviceMessage) o;

    return Objects.equals(this.getProductId(), text.getProductId())
            && Objects.equals(this.getDeviceNumber(), text.getDeviceNumber());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getDeviceNumber(), this.getProductId());
  }
}