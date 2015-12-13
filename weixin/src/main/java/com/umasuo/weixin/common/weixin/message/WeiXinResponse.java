package com.umasuo.weixin.common.weixin.message;

import java.util.ArrayList;
import java.util.List;

/**
 * response with xml format  wechat server
 * <p>class: WeiXinResponse.java </p>
 * <p>description: com.umasuo.weixin.common.weixin.message </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月13日 上午11:38:26
 */
public class WeiXinResponse {
    //base infos
    public String ToUserName;
    public String FromUserName;
    public String CreateTime;
    public String MsgType;
    public String FuncFlag;

    /**
     * 响应微信请求的Header，用于处理固定信息
     * @return
     */
    public String buildHeader(){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(ToUserName).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(FromUserName).append("]]></FromUserName>");
        sb.append("<MsgType>").append(MsgType).append("</MsgType>");
        sb.append("<CreateTime>").append(System.currentTimeMillis()/1000).append("</CreateTime>");
        return sb.toString();
    }
    
    /**
     * 响应微信请求的footer
     * @return
     */
    public String buildFooter(){
        StringBuilder sb = new StringBuilder();
        if (null == FuncFlag) {
            sb.append("<FuncFlag>").append(0).append("</FuncFlag>");
        }else{
            sb.append("<FuncFlag>").append(1).append("</FuncFlag>");
        }
        sb.append("</xml>");
        return sb.toString();
    }
    
    /**
     * 文本类回复
     * @author umasuo
     *
     */
    public static class TextResponse extends WeiXinResponse{
        public String Content;
        public TextResponse(){
            this.MsgType = "text";
        }
        public String build(){
            StringBuffer content = new StringBuffer();
            content.append("<Content>").append(Content).append("</Content>");
            String retMsg = buildHeader() + content.toString() + buildFooter();
            return retMsg;
        }
    }
    public static class CustomerResponse extends WeiXinResponse{
        public CustomerResponse(){
            this.MsgType = "transfer_customer_service";
        }
        public String build(){
            String retMsg = buildHeader() + buildFooter();
            return retMsg;
        }
    }
   
    /**
     * 图片类回复消息体
     * @author umasuo
     *
     */
    public static class ImageResponse extends WeiXinResponse{
        public String MediaId;
        public ImageResponse(){
            this.MsgType = "image";
        }
        public String build(){
            StringBuffer content = new StringBuffer();
            content.append("<Image><MediaId><![CDATA[").append(this.MediaId).append("]]></MediaId></Image>");
            String retMsg = buildHeader() + content.toString() + buildFooter();
            return retMsg;
        }
    }
    
    /**
     * 声音类回复消息体
     * @author umasuo
     *
     */
    public static class VoiceResponse extends WeiXinResponse{
        public String MediaId;
        public VoiceResponse(){
            this.MsgType = "voice";
        }
        public String build(){
            StringBuffer content = new StringBuffer();
            content.append("<Voice><MediaId><![CDATA[").append(this.MediaId).append("]]></MediaId></Voice>");
            String retMsg = buildHeader() + content.toString() + buildFooter();
            return retMsg;
        }
    }
    
    /**
     * 视频类回复消息体
     * @author umasuo
     *
     */
    public static class VideoResponse extends WeiXinResponse{
        public String MediaId;
        public String Title;
        public String Description;
        public VideoResponse(){
            this.MsgType = "video";
        }
        public String build(){
            StringBuffer content = new StringBuffer();
            content.append("<Video>");
            content.append("<MediaId><![CDATA[").append(this.MediaId).append("]]></MediaId>");
            content.append("<Title><![CDATA[").append(this.Title).append("]]></Title>");
            content.append("<Description><![CDATA[").append(this.Description).append("]]></Description>");
            content.append("</Video>");
            String retMsg = buildHeader() + content.toString() + buildFooter();
            return retMsg;
        }
    }
    
    /**
     * 音乐回复消息体
     * @author umasuo
     *
     */
    public static class MusicResponse extends WeiXinResponse{
        public String Title;
        public String Description;
        public String MusicUrl;
        public String HQMusicUrl;
        public String ThumbMediaId;
        public MusicResponse(){
            this.MsgType = "music";
        }
        public String build(){
            StringBuffer content = new StringBuffer();
            content.append("<Music>");
            content.append("<Title><![CDATA[").append(this.Title).append("]]></Title>");
            content.append("<Description><![CDATA[").append(this.Description).append("]]></Description>");
            content.append("<MusicUrl><![CDATA[").append(this.MusicUrl).append("]]></MusicUrl>");
            content.append("<HQMusicUrl><![CDATA[").append(this.HQMusicUrl).append("]]></HQMusicUrl>");
            content.append("<ThumbMediaId><![CDATA[").append(this.ThumbMediaId).append("]]></ThumbMediaId>");
            content.append("</Music>");
            String retMsg = buildHeader() + content.toString() + buildFooter();
            return retMsg;
        }
    }
    
    /**
     * 文章类回复消息体
     * @author umasuo
     *
     */
    public static class ArticleResponse extends WeiXinResponse{
        public String ArticleCount;
        public List<Article> Articles;
        public String MusicUrl;
        public String HQMusicUrl;
        public String ThumbMediaId;
        
        public ArticleResponse(){
            this.MsgType = "music";
            Articles = new ArrayList<Article>();
        }
        public String build(){
            StringBuffer content = new StringBuffer();
            content.append("<ArticleCount>").append(this.ArticleCount).append("</ArticleCount>");
            content.append("<Articles>");
            for (Article article : Articles) {
                content.append("<item>");
                content.append("<Title><![CDATA[").append(article.Title).append("]]></Title>");
                content.append("<Description><![CDATA[").append(article.Description).append("]]></Description>");
                content.append("<PicUrl><![CDATA[").append(article.PicUrl).append("]]></PicUrl>");
                content.append("<Url><![CDATA[").append(article.Url).append("]]></Url>");
                content.append("</item>");
            }
            content.append("</Articles>");
            String retMsg = buildHeader() + content.toString() + buildFooter();
            return retMsg;
        }
    }
    
    /**
     * 具体文章消息体
     * @author umasuo
     *
     */
    public static class Article{
        public String Title; 
        public String Description; 
        public String PicUrl; 
        public String Url; 
    }
    
    /**
     * use to build hardware sns response
     * @author umasuo
     *
     */
    public static class HardwareResponse extends WeiXinResponse{
        public String Content = "<HardWare><MessageView><![CDATA[myrank]]></MessageView><MessageAction><![CDATA[ranklist]]></MessageAction></HardWare>";
        public HardwareResponse(){
            this.MsgType = "hardware";
        }
        public String build(){
            String retMsg = buildHeader() + Content + buildFooter();
            return retMsg;
        }
    }
    
    /**
     * 回复给硬件设备的消息。Content是需要发送给设备的消息，需要进行base64加密。
     * @author umasuo
     *
     */
    public static class DeviceTextResponse extends WeiXinResponse{
        public String DeviceType;
        public String DeviceID;
        public String SessionID;
        public String Content;
        
        public DeviceTextResponse(){
            this.MsgType = "device_text";
        }
        public String build(){
            StringBuffer content = new StringBuffer();
            content.append("<DeviceType><![CDATA[").append(this.DeviceType).append("]]></DeviceType>");
            content.append("<DeviceID><![CDATA[").append(this.DeviceID).append("]]></DeviceID>");
            content.append("<SessionID><![CDATA[").append(this.SessionID).append("]]></SessionID>");
            content.append("<Content><![CDATA[").append(this.Content).append("]]></Content>");
            String retMsg = buildHeader() + Content + buildFooter();
            return retMsg;
        }
    }
    
}

