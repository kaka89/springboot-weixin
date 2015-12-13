package com.umasuo.weixin.common.weixin.message;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * message decoder for wechat's message
 * <p>class: WeiXinMessageUtil.java </p>
 * <p>description: com.umasuo.weixin.common.weixin.message </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月13日 上午11:41:52
 */
public class WeiXinMessageUtil {
    private final static Logger logger = LoggerFactory.getLogger(WeiXinMessageUtil.class);

    /**
     * 用于解析微信过来的消息
     * @param msg
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static WeiXinMessage decodeMessage(String msg){
        SAXReader saxreader = new SAXReader();
        WeiXinMessage message = new WeiXinMessage();
        
        Class msgClass = message.getClass(); 
        try {
            Document doc = saxreader.read(new ByteArrayInputStream(msg.getBytes("UTF-8")));
            Element root = doc.getRootElement();
            for (Iterator values = root.elementIterator();values.hasNext();) {  
                Element value = (Element) values.next();
                try{
                    Field filed = msgClass.getField(value.getName());
                    filed.set(message, value.getTextTrim());
                }catch (NoSuchFieldException e){
                    logger.warn("decode weixin message warning:no such field.field name:"+value.getName());
                    e.printStackTrace();
                }catch (IllegalAccessException e){
                    logger.warn("decode weixin message warning:illegal access.filed name:"+value.getName());
                    e.printStackTrace();
                }
            } 
        } catch (DocumentException e) {
            logger.warn("decode weixin message error:"+e.getMessage());
            e.printStackTrace();
        }catch( UnsupportedEncodingException e){
            logger.warn("decode weixin message error:"+e.getMessage());
            e.printStackTrace();
        }
        return message;
    }
    
    /**
     * TODO:这得改成自动识别字段的，不然改动消息体时很麻烦
     * 将消息体封装成xml的string
     * @param msg
     * @return
     */
    public static String encodeMessage(WeiXinResponse msg){
        
        return"";
    }

    /**
     * build text response message
     * @param msg
     * @return xml string message
     */
    public static String buildTextResponse(WeiXinMessage msg){
        StringBuffer content = new StringBuffer();
        content.append("<MsgType>").append(msg.MsgType).append("</MsgType>");
        content.append("<Content>").append(msg.Content).append("</Content>");
        String retMsg = buildHeader(msg) + content.toString() + buildFooter(msg);
        return retMsg;
    }
    
    /**
     * build the header
     * @param msg
     * @return
     */
    public static String buildHeader(WeiXinMessage msg){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(msg.ToUserName).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(msg.FromUserName).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(System.currentTimeMillis()/1000).append("</CreateTime>");
        return sb.toString();
    }
    
    /**
     * build the footer
     * @param msg
     * @return
     */
    public static String buildFooter(WeiXinMessage msg){
        StringBuilder sb = new StringBuilder();
        if (null == msg.FuncFlag) {
            sb.append("<FuncFlag>").append(0).append("</FuncFlag>");
        }else{
            sb.append("<FuncFlag>").append(1).append("</FuncFlag>");
        }
        sb.append("</xml>");
        return sb.toString();
    }
    
    
//    public static void main(String[] args){
//        String msg = "<xml><ToUserName><![CDATA[gh_c761e0b57d20]]></ToUserName><FromUserName><![CDATA[o-oBAwpSjGuQt7CDN9ur5rlDZod4]]></FromUserName><CreateTime>1447762149</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[CLICK]]></Event><EventKey><![CDATA[hm_current_steps]]></EventKey></xml> ";
//        WeiXinMessage message = WeiXinMessageUtil.decodeMessage(msg);
//        logger.info(message.toString());
//        logger.info(WeiXinMessageUtil.encodeMessage(message));
//    }
}
