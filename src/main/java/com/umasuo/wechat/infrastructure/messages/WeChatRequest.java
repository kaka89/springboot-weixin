
package com.umasuo.wechat.infrastructure.messages;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * The request from wechat.
 * Reference: http://iot.weixin.qq.com/wiki/document-2_1.html
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatRequest {

  public static final String MSG_TYPE_DEVICE_EVENT = "device_event";
  public static final String MSG_TYPE_DEVICE_TEXT = "device_text";
  public static final String MSG_TYPE_CUSTOMER_SERVICE = "transfer_customer_service";
  public static final String MSG_TYPE_EVENT = "event";
  public static final String MSG_TYPE_TEXT = "text";
  public static final String MSG_EVENT_SUBSCRIBE = "subscribe";
  public static final String MSG_EVENT_UNSUBSCRIBE = "unsubscribe";
  public static final String MSG_EVENT_CLICK = "CLICK";
  public static final String MSG_EVENT_CLICK_CUR_STEP = "hm_current_steps";
  public static final String MSG_EVENT_CLICK_RANK = "hm_wx_top";
  public static final String MSG_DEVICE_EVENT_BIND = "bind";
  public static final String MSG_DEVICE_EVENT_UNBIND = "unbind";
  public static final String MSG_DEFAULT = "default";

  @XmlElement(name = "ToUserName")
  @XmlCDATA
  private String toUserName;

  @XmlElement(name = "FromUserName")
  @XmlCDATA
  private String fromUserName;

  @XmlElement(name = "CreateTime")
  @XmlCDATA
  private String createTime;

  @XmlElement(name = "MsgType")
  @XmlCDATA
  private String msgType;

  @XmlElement(name = "Content")
  @XmlCDATA
  private String content;

  @XmlElement(name = "MsgId")
  @XmlCDATA
  private String msgId;

  @XmlElement(name = "Latitude")
  @XmlCDATA
  public String latitude;

  @XmlElement(name = "Event")
  @XmlCDATA
  public String event;

  @XmlElement(name = "Longitude")
  @XmlCDATA
  public String longitude;

  @XmlElement(name = "Precision")
  @XmlCDATA
  public String precision;

  @XmlElement(name = "DeviceID")
  @XmlCDATA
  public String deviceId;

  @XmlElement(name = "DeviceType")
  @XmlCDATA
  public String deviceType;

  @XmlElement(name = "SessionID")
  @XmlCDATA
  public String sessionId;

  @XmlElement(name = "OpenID")
  @XmlCDATA
  public String openId;

  @XmlElement(name = "FuncFlag")
  public String funcFlag;

  @XmlElement(name = "Ticket")
  @XmlCDATA
  public String ticket;

  @XmlElement(name = "EventKey")
  @XmlCDATA
  public String eventKey;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    WeChatRequest other = (WeChatRequest) o;

    return Objects.equals(this.getContent(), other.getContent())
            && Objects.equals(this.getCreateTime(), other.getCreateTime())
            && Objects.equals(this.getDeviceId(), other.getDeviceId())
            && Objects.equals(this.getDeviceType(), other.getDeviceType())
            && Objects.equals(this.getEvent(), other.getEvent())
            && Objects.equals(this.getEventKey(), other.getEventKey())
            && Objects.equals(this.getFromUserName(), other.getFromUserName())
            && Objects.equals(this.getFuncFlag(), other.getFuncFlag())
            && Objects.equals(this.getLatitude(), other.getLatitude())
            && Objects.equals(this.getLongitude(), other.getLongitude())
            && Objects.equals(this.getMsgId(), other.getMsgId())
            && Objects.equals(this.getMsgType(), other.getMsgType())
            && Objects.equals(this.getOpenId(), other.getOpenId())
            && Objects.equals(this.getPrecision(), other.getPrecision())
            && Objects.equals(this.getSessionId(), other.getSessionId())
            && Objects.equals(this.getTicket(), other.getTicket())
            && Objects.equals(this.getToUserName(), other.getToUserName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getContent(),
            this.getCreateTime(),
            this.getDeviceId(),
            this.getDeviceType(),
            this.getEvent(),
            this.getEventKey(),
            this.getFromUserName(),
            this.getFuncFlag(),
            this.getLatitude(),
            this.getLongitude(),
            this.getMsgId(),
            this.getMsgType(),
            this.getOpenId(),
            this.getPrecision(),
            this.getSessionId(),
            this.getTicket(),
            this.getToUserName());
  }

  @Override
  public String toString() {
    return com.google.common.base.MoreObjects.toStringHelper(this)
            .add("Content", this.getContent())
            .add("CreateTime", this.getCreateTime())
            .add("DeviceId", this.getDeviceId())
            .add("DeviceType", this.getDeviceType())
            .add("Event", this.getEvent())
            .add("EventKey", this.getEventKey())
            .add("FromUserName", this.getFromUserName())
            .add("FuncFlag", this.getFuncFlag())
            .add("Latitude", this.getLatitude())
            .add("Longitude", this.getLongitude())
            .add("MsgId", this.getMsgId())
            .add("MsgType", this.getMsgType())
            .add("OpenId", this.getOpenId())
            .add("Precision", this.getPrecision())
            .add("SessionId", this.getSessionId())
            .add("Ticket", this.getTicket())
            .add("ToUserName", this.getToUserName())
            .toString();
  }

  public String getToUserName() {
    return this.toUserName;
  }

  public void setToUserName(String toUserName) {
    this.toUserName = toUserName;
  }

  public String getFromUserName() {
    return this.fromUserName;
  }

  public void setFromUserName(String fromUserName) {
    this.fromUserName = fromUserName;
  }

  public String getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getMsgType() {
    return this.msgType;
  }

  public void setMsgType(String msgType) {
    this.msgType = msgType;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getMsgId() {
    return this.msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public String getLatitude() {
    return this.latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getEvent() {
    return this.event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public String getLongitude() {
    return this.longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getPrecision() {
    return this.precision;
  }

  public void setPrecision(String precision) {
    this.precision = precision;
  }

  public String getDeviceId() {
    return this.deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getDeviceType() {
    return this.deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getOpenId() {
    return this.openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getFuncFlag() {
    return this.funcFlag;
  }

  public void setFuncFlag(String funcFlag) {
    this.funcFlag = funcFlag;
  }

  public String getTicket() {
    return this.ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public String getEventKey() {
    return this.eventKey;
  }

  public void setEventKey(String eventKey) {
    this.eventKey = eventKey;
  }

}
