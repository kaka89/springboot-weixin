package com.umasuo.weixin.common.weixin.message;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * here include all the return messages to wechat server 
 * <p>class: WeiXinRequest.java </p>
 * <p>description: com.umasuo.weixin.common.weixin.message </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:00:00
 */
public class WeiXinRequest {
    public String touser;// the user's openid
    public String msgtype;// message type

    public String getTouser() {
        return touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public String build() {
        JSONObject jsonObj = JSONObject.fromObject(this);
        return jsonObj.toString();
    }

    public static class TextRequest extends WeiXinRequest {
        public class Text {
            public String content;

            public String getContent() {
                return content;
            }
        }

        public Text text;

        public Text getText() {
            return text;
        }

        public TextRequest(String content) {
            this.msgtype = "text";
            this.text = new Text();
            this.text.content = content;
        }
    }

    public static class ImageRequest extends WeiXinRequest {
        public class Image {
            public String media_id;

            public String getMedia_id() {
                return media_id;
            }
        }

        public Image image;

        public Image getImage() {
            return image;
        }

        public ImageRequest(String mediaId) {
            this.msgtype = "image";
            this.image = new Image();
            this.image.media_id = mediaId;
        }
    }

    public static class VoiceRequest extends WeiXinRequest {
        public class Voice {
            public String media_id;

            public String getMedia_id() {
                return media_id;
            }
        }

        public Voice voice;

        public Voice getVoice() {
            return voice;
        }

        public VoiceRequest(String mediaId) {
            this.voice = new Voice();
            this.msgtype = "voice";
            this.voice.media_id = mediaId;
        }
    }

    public static class VideoRequest extends WeiXinRequest {
        public class Video {
            public String media_id;
            public String thumb_media_id;
            public String title;
            public String description;

            public String getMedia_id() {
                return media_id;
            }

            public String getThumb_media_id() {
                return thumb_media_id;
            }

            public String getTitle() {
                return title;
            }

            public String getDescription() {
                return description;
            }

        }

        public Video video;

        public Video getVoice() {
            return video;
        }

        public VideoRequest(String mediaId, String thumbMediaId, String title,
                String description) {
            this.video = new Video();
            this.msgtype = "video";
            this.video.media_id = mediaId;
            this.video.thumb_media_id = thumbMediaId;
            this.video.title = title;
            this.video.description = description;
        }
    }

    public static class MusicRequest extends WeiXinRequest {
        public class Music {
            public String title;
            public String description;
            public String musicurl;
            public String hqmusicurl;
            public String thumb_media_id;

            public String getTitle() {
                return title;
            }

            public String getDescription() {
                return description;
            }

            public String getMusicurl() {
                return musicurl;
            }

            public String getHqmusicurl() {
                return hqmusicurl;
            }

            public String getThumb_media_id() {
                return thumb_media_id;
            }
        }

        public Music music;

        public Music getMusic() {
            return music;
        }

        public MusicRequest(String title, String description, String musicurl,
                String hqmusicurl, String thumbMediaId) {
            this.music = new Music();
            this.msgtype = "voice";
            this.music.title = title;
            this.music.description = description;
            this.music.musicurl = musicurl;
            this.music.hqmusicurl = hqmusicurl;
            this.music.thumb_media_id = thumbMediaId;
        }
    }

    public static class NewsRequest extends WeiXinRequest {
        public static class Article {
            public String title;
            public String description;
            public String url;
            public String picurl;

            public String getTitle() {
                return title;
            }

            public String getDescription() {
                return description;
            }

            public String getUrl() {
                return url;
            }

            public String getPicurl() {
                return picurl;
            }
        }

        public class News {
            public List<Article> articles = new ArrayList<Article>();

            public List<Article> getArticles() {
                return articles;
            }
        }

        public News news;

        public News getNews() {
            return news;
        }

        public NewsRequest(List<Article> articles) {
            this.news = new News();
            this.msgtype = "news";
            this.news.articles.addAll(articles);
        }
    }

    /**
     * send text message to device
     * 
     * @author umasuo
     *
     */
    public static class DeviceTextRequest {
        public String device_type;
        public String device_id;
        public String open_id;
        public String content;

        public String getDevice_type() {
            return device_type;
        }

        public String getDevice_id() {
            return device_id;
        }

        public String getOpen_id() {
            return open_id;
        }

        public String getContent() {
            return content;
        }

        public DeviceTextRequest(String deviceType, String deviceId,
                String openId, String content) {
            this.device_type = deviceType;
            this.device_id = deviceId;
            this.open_id = openId;
            this.content = content;
        }

        public String build() {
            JSONObject jsonObj = JSONObject.fromObject(this);
            return jsonObj.toString();
        }
    }

    /**
     * 请求生成设备二维码的时候的
     * 
     * @author umasuo
     *
     */
    public static class DeviceQrcodeRequest {
        public String device_num;
        public List<String> device_id_list = new ArrayList<String>();

        public String getDevice_num() {
            return device_num;
        }

        public List<String> getDevice_id_list() {
            return device_id_list;
        }

        public DeviceQrcodeRequest(String deviceNum, List<String> deviceIdList) {
            this.device_num = deviceNum;
            this.device_id_list = deviceIdList;
        }
        public DeviceQrcodeRequest(String deviceId) {
            this.device_num = "1";
            this.device_id_list.add(deviceId);
        }

        public String build() {
            JSONObject jsonObj = JSONObject.fromObject(this);
            return jsonObj.toString();
        }
    }

    /**
     * 给设备授权时的请求对象
     * @author umasuo
     *
     */
    public static class AuthorizeDeviceRequest {
        public String device_num;
        public List<Device> device_list = new ArrayList<Device>(); 
        public String op_type;
        public String product_id;
        public static class Device {
            String id;
            String mac;
            String connect_protocol;
            String auth_key;
            String close_strategy;
            String conn_strategy;
            String crypt_method;
            String auth_ver;
            String manu_mac_pos;
            String ser_mac_pos;
            String ble_simple_protocol;

            public Device(String id, 
                    String mac,
                    String connect_protocol,
                    String auth_key, 
                    String close_strategy,
                    String conn_strategy, 
                    String crypt_method, 
                    String auth_ver,
                    String manu_mac_pos, 
                    String ser_mac_pos,
                    String ble_simple_protocol) {
                this.id=id;
                this.mac = mac;
                this.connect_protocol = connect_protocol;
                this.auth_key = auth_key;
                this.close_strategy = close_strategy;
                this.conn_strategy = conn_strategy;
                this.crypt_method = crypt_method;
                this.auth_ver = auth_ver;
                this.manu_mac_pos = manu_mac_pos;
                this.ser_mac_pos = ser_mac_pos;
                this.ble_simple_protocol = ble_simple_protocol;
            }

            public String getId() {
                return id;
            }

            public String getMac() {
                return mac;
            }

            public String getConnect_protocol() {
                return connect_protocol;
            }

            public String getAuth_key() {
                return auth_key;
            }

            public String getClose_strategy() {
                return close_strategy;
            }

            public String getConn_strategy() {
                return conn_strategy;
            }

            public String getCrypt_method() {
                return crypt_method;
            }

            public String getAuth_ver() {
                return auth_ver;
            }

            public String getManu_mac_pos() {
                return manu_mac_pos;
            }

            public String getSer_mac_pos() {
                return ser_mac_pos;
            }

            public String getBle_simple_protocol() {
                return ble_simple_protocol;
            }
        
        }
        
        public String getDevice_num() {
            return device_num;
        }
        public List<Device> getDevice_list() {
            return device_list;
        }
        public String getOp_type() {
            return op_type;
        }
        public String getProduct_id() {
            return product_id;
        }
        public String build() {
            JSONObject jsonObj = JSONObject.fromObject(this);
            return jsonObj.toString();
        }
        
    }

    // public static void main(String[] args){
    // WeiXinRequest.NewsRequest.Article article1 = new
    // WeiXinRequest.NewsRequest.Article();
    // article1.title = "title1";
    // article1.description = "description1";
    // article1.picurl = "picurl1";
    // article1.url = "url1";
    // WeiXinRequest.NewsRequest.Article article2 = new
    // WeiXinRequest.NewsRequest.Article();
    // article2.title = "title2";
    // article2.description = "description2";
    // article2.picurl = "picurl2";
    // article2.url = "url2";
    // List<WeiXinRequest.NewsRequest.Article> articles = new
    // ArrayList<WeiXinRequest.NewsRequest.Article>();
    // articles.add(article1);
    // articles.add(article2);
    //
    // List<String> array = new ArrayList<String>();
    // array.add("key1");
    // array.add("key2");
    // array.add("key3");
    // DeviceQrCodeRequest text = new DeviceQrCodeRequest("3",array);
    // // text.touser = "ttt";
    // System.out.println(text.build());
    // }
}
