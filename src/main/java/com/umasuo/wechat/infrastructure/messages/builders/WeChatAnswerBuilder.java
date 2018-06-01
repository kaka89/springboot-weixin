
package com.umasuo.wechat.infrastructure.messages.builders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class WeChatAnswerBuilder {

  private static JAXBContext context;
  private static Unmarshaller unmarshaller;
  private static Marshaller marshaller;

  @SuppressWarnings("unchecked")
  public static <T> T decodeRequest(String data, Class<T> clazz) throws JAXBException {
    Unmarshaller unmarshaller = WeChatAnswerBuilder.getUnmarshaller(clazz);

    T response = (T) unmarshaller.unmarshal(new StringReader(data));
    return response;
  }

  public static <T> String encodeRequest(T answer, Class<T> clazz) throws JAXBException {
    Marshaller marshaller = WeChatAnswerBuilder.getMarshaller(clazz);
    StringWriter writer = new StringWriter();

    marshaller.marshal(answer, writer);
    return writer.toString();
  }

  private static <T> Unmarshaller getUnmarshaller(Class<T> clazz) throws JAXBException {

    if (context == null) {
      context = JAXBContext.newInstance(clazz);
    }

    if (unmarshaller == null) {
      unmarshaller = context.createUnmarshaller();
    }
    return unmarshaller;
  }

  private static <T> Marshaller getMarshaller(Class<T> clazz) throws JAXBException {

    if (context == null) {
      context = JAXBContext.newInstance(clazz);
    }

    if (marshaller == null) {
      marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");//编码格式
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化生成的xml串
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//是否省略xm头声明信息

    }
    return marshaller;
  }

}
