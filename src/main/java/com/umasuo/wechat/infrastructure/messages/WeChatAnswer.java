
package com.umasuo.wechat.infrastructure.messages;

import lombok.Data;
import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * the response for the wechat request
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class WeChatAnswer {

  @XmlElement(name = "ToUserName")
  @XmlCDATA
  public String toUserName;

  @XmlElement(name = "FromUserName")
  @XmlCDATA
  public String fromUserName;

  @XmlElement(name = "CreateTime")
  public String createTime;

  @XmlElement(name = "MsgType")
  public String msgType;

  @XmlElement(name = "FuncFlag")
  public String funcFlag;

  @XmlRootElement(name = "xml")
  @XmlAccessorType(XmlAccessType.FIELD)
  @Data
  public static class RankAnswer extends WeChatAnswer {

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    public static class Rank {
      @XmlElement(name = "MessageView")
      @XmlCDATA
      public String msgView;

      @XmlElement(name = "MessageAction")
      @XmlCDATA
      public String msgAction;

    }

    @XmlElement(name = "HardWare")
    public Rank rank;

    public RankAnswer() {
      this.setMsgType("hardware");
      this.rank = new Rank();
      this.rank.setMsgView("myrank");
      this.rank.setMsgAction("ranklist");
    }

  }


}
