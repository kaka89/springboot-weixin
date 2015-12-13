package com.umasuo.weixin.common.weixin.message;

/**
 * the message from wechat server
 * <p>class: WeiXinMessage.java </p>
 * <p>description: com.umasuo.weixin.common.weixin.message </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月13日 上午11:41:08
 */
public class WeiXinMessage {

    public String ToUserName;
    public String FromUserName;
    public String CreateTime;
    public String MsgType;
    public String Content;
    public String MsgId;
    public String Latitude;
    public String Event;
    public String Longitude;
    public String Precision;
    public String DeviceID;
    public String DeviceType;
    public String SessionID;
    public String OpenID;
    public String FuncFlag;
    public String Ticket;
    public String EventKey;
    public String Hardware = "<MessageView><![CDATA[myrank]]></MessageView><MessageAction><![CDATA[ranklist]]></MessageAction>";
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ToUserName:").append(ToUserName).append("&");
        sb.append("FromUserName:").append(FromUserName).append("&");
        sb.append("CreateTime:").append(CreateTime).append("&");
        sb.append("MsgType:").append(MsgType).append("&");
        sb.append("Content:").append(Content).append("&");
        sb.append("MsgId:").append(MsgId).append("&");
        sb.append("Latitude:").append(Latitude).append("&");
        sb.append("Event:").append(Event).append("&");
        sb.append("Longitude:").append(Longitude).append("&");
        sb.append("Precision:").append(Precision);
        return sb.toString();
    }

    
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public String getOpenID() {
        return OpenID;
    }

    public void setOpenID(String openID) {
        OpenID = openID;
    }

    public String getFuncFlag() {
        return FuncFlag;
    }

    public void setFuncFlag(String funcFlag) {
        FuncFlag = funcFlag;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getHardware() {
        return Hardware;
    }

    public void setHardware(String hardware) {
        Hardware = hardware;
    }
    
    
}

class Hardware{
    public String MessageView;
    public String MessageAction;
}