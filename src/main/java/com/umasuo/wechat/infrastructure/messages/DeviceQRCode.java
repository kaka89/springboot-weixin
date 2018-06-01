
package com.umasuo.wechat.infrastructure.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DeviceQRCode {

  @JsonProperty
  private String userId;
  @JsonProperty
  private String appName;
  @JsonProperty
  private String toUserName;
  @JsonProperty
  private String ticket;
  @JsonProperty
  private String deviceId;

}
