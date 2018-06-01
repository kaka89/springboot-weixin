package com.umasuo.wechat.infrastructure.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * send user manage message to wechat server
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserManageMessage implements Serializable {

  private static final long serialVersionUID = 6883399195935599836L;

  @JsonProperty("openid")
  private String openId;

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class GroupManageMessage extends UserManageMessage {

    private static final long serialVersionUID = 3518168946891602258L;
    @JsonProperty("to_groupid")
    private String toGroupId;

  }

  @Data
  public static class RemarkManageMessage extends UserManageMessage {

    private static final long serialVersionUID = -6093661151244285900L;

    @JsonProperty("remark")
    private String remark;

  }

}
