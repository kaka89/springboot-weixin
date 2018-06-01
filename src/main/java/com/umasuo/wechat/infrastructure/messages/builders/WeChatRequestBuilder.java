
package com.umasuo.wechat.infrastructure.messages.builders;


import com.umasuo.wechat.infrastructure.messages.WeChatRequest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class WeChatRequestBuilder {

  private static JAXBContext context;
  private static Unmarshaller unmarshaller;
  private static Marshaller marshaller;
  private static StringWriter writer;

  public static WeChatRequest decodeRequest(String data) throws JAXBException {
    Unmarshaller unmarshaller = WeChatRequestBuilder.getUnmarshaller();
    WeChatRequest request = (WeChatRequest) unmarshaller.unmarshal(new StringReader(data));
    return request;
  }

  public static String encodeRequest(WeChatRequest request) throws JAXBException {
    Marshaller marshaller = WeChatRequestBuilder.getMarshaller();

    marshaller.marshal(request, writer);
    return writer.toString();
  }

  public static WeChatRequest createTestRequest() {
    WeChatRequest request = new WeChatRequest();
    request.setContent("content");
    request.setCreateTime("createTime");
    request.setFromUserName("fromeUserName");
    request.setMsgId("messageId");
    request.setMsgType("messageType");
    request.setToUserName("toUserName");
    return request;
  }

  private static Unmarshaller getUnmarshaller() throws JAXBException {

    if (context == null) {
      context = JAXBContext.newInstance(WeChatRequest.class);
    }

    if (unmarshaller == null) {
      unmarshaller = context.createUnmarshaller();
    }
    return unmarshaller;
  }

  private static Marshaller getMarshaller() throws JAXBException {

    if (context == null) {
      context = JAXBContext.newInstance(WeChatRequest.class);
    }

    if (marshaller == null) {
      marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");//编码格式
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化生成的xml串
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//是否省略xm头声明信息

    }
    if (writer == null) {
      writer = new StringWriter();
    }
    return marshaller;
  }

}
