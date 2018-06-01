
package com.umasuo.wechat.infrastructure.messages.builders;


import com.umasuo.wechat.infrastructure.messages.UserManageMessage.GroupManageMessage;
import com.umasuo.wechat.infrastructure.messages.UserManageMessage.RemarkManageMessage;

public class UserManageMessageBuilder {

  public static GroupManageMessage createGroupMessageTestModel() {
    GroupManageMessage message = new GroupManageMessage();
    message.setOpenId("this is open id");
    message.setToGroupId("101");
    return message;
  }

  public static RemarkManageMessage createRemarkMessageTestModel() {
    RemarkManageMessage message = new RemarkManageMessage();
    message.setOpenId("this is open id");
    message.setRemark("remark");
    return message;
  }
}
