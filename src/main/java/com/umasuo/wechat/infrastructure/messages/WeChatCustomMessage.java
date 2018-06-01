package com.umasuo.wechat.infrastructure.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 这里包含了主动发送给微信用户端的所有类型的消息体
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeChatCustomMessage implements Serializable {

  private static final long serialVersionUID = 4185035068133611712L;

  @JsonProperty("touser")
  protected String toUser;

  @JsonProperty("msgtype")
  protected String msgType;// message type

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class TextMessage extends WeChatCustomMessage {
    private static final long serialVersionUID = -3701649372842689881L;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Text implements Serializable {
      private static final long serialVersionUID = -3731003497541469331L;
      private String content;

    }

    @JsonProperty("text")
    private Text text;

    public Text getText() {
      return this.text;
    }

    public TextMessage(String content) {
      this.msgType = "text";
      this.text = new Text();
      this.text.setContent(content);
    }

    public TextMessage(String toUser, String content) {
      this.toUser = toUser;
      this.msgType = "text";
      this.text = new Text();
      this.text.setContent(content);
    }

    public TextMessage() {
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      TextMessage text = (TextMessage) o;

      return Objects.equals(this.getToUser(), text.getToUser())
              && Objects.equals(this.getMsgType(), text.getMsgType())
              && Objects.equals(this.getText().getContent(), text.getText().getContent());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
              this.getToUser(),
              this.getMsgType(),
              this.getText().getContent());
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class ImageMessage extends WeChatCustomMessage {
    private static final long serialVersionUID = -8045790102987544127L;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Image implements Serializable {
      private static final long serialVersionUID = -2568390145285144391L;
      @JsonProperty("media_id")
      private String mediaId;

      public Image() {
      }

    }

    @JsonProperty
    private Image image;

    public Image getImage() {
      return this.image;
    }

    public ImageMessage(String mediaId) {
      this.msgType = "image";
      this.image = new Image();
      this.image.mediaId = mediaId;
    }

    public ImageMessage() {
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      ImageMessage image = (ImageMessage) o;

      return Objects.equals(this.getToUser(), image.getToUser())
              && Objects.equals(this.getMsgType(), image.getMsgType())
              && Objects.equals(this.getImage().getMediaId(), image.getImage().getMediaId());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
              this.getToUser(),
              this.getMsgType(),
              this.getImage().getMediaId());
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class VoiceMessage extends WeChatCustomMessage {
    private static final long serialVersionUID = -760791206912980297L;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Voice implements Serializable {
      private static final long serialVersionUID = -1597933661916063116L;

      @JsonProperty("media_id")
      public String mediaId;

    }

    @JsonProperty
    private Voice voice;

    public Voice getVoice() {
      return this.voice;
    }

    public VoiceMessage(String mediaId) {
      this.voice = new Voice();
      this.msgType = "voice";
      this.voice.setMediaId(mediaId);
    }

    public VoiceMessage() {
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      VoiceMessage voice = (VoiceMessage) o;

      return Objects.equals(this.getToUser(), voice.getToUser())
              && Objects.equals(this.getMsgType(), voice.getMsgType())
              && Objects.equals(this.getVoice().getMediaId(), voice.getVoice().getMediaId());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
              this.getToUser(),
              this.getMsgType(),
              this.getVoice().getMediaId());
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class VideoMessage extends WeChatCustomMessage {
    private static final long serialVersionUID = 794912991199916944L;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Video implements Serializable {
      private static final long serialVersionUID = -1498805412259765430L;
      @JsonProperty("media_id")
      private String mediaId;
      @JsonProperty("thumb_media_id")
      private String thumbMediaId;
      @JsonProperty
      private String title;
      @JsonProperty
      private String description;

    }

    @JsonProperty
    public Video video;

    public Video getVideo() {
      return this.video;
    }

    public VideoMessage(String mediaId, String thumbMediaId, String title,
                        String description) {
      this.video = new Video();
      this.msgType = "video";
      this.video.setMediaId(thumbMediaId);
      this.video.setThumbMediaId(thumbMediaId);
      this.video.setTitle(title);
      this.video.setDescription(description);
    }

    public VideoMessage() {
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      VideoMessage video = (VideoMessage) o;

      return Objects.equals(this.getToUser(), video.getToUser())
              && Objects.equals(this.getMsgType(), video.getMsgType())
              && Objects.equals(this.getVideo().getMediaId(), video.getVideo().getMediaId());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
              this.getToUser(),
              this.getMsgType(),
              this.getVideo().getMediaId());
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class MusicMessage extends WeChatCustomMessage {
    private static final long serialVersionUID = -5631459636997619210L;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Music implements Serializable {
      private static final long serialVersionUID = 879285078282916770L;
      @JsonProperty
      private String title;
      @JsonProperty
      private String description;
      @JsonProperty("musicUrl")
      private String musicUrl;
      @JsonProperty("hqmusicurl")
      private String hqMusicUrl;
      @JsonProperty("thumb_media_id")
      private String thumbMediaId;

    }

    @JsonProperty
    public Music music;

    public Music getMusic() {
      return this.music;
    }

    public MusicMessage(String title, String description, String musicUrl,
                        String hqMusicUrl, String thumbMediaId) {
      this.music = new Music();
      this.msgType = "music";
      this.music.setTitle(title);
      this.music.setDescription(description);
      this.music.setMusicUrl(musicUrl);
      this.music.setHqMusicUrl(hqMusicUrl);
      this.music.setThumbMediaId(thumbMediaId);
    }

    public MusicMessage() {
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      MusicMessage music = (MusicMessage) o;

      return Objects.equals(this.getToUser(), music.getToUser())
              && Objects.equals(this.getMsgType(), music.getMsgType())
              && Objects.equals(this.getMusic().getThumbMediaId(),
              music.getMusic().getThumbMediaId());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
              this.getToUser(),
              this.getMsgType(),
              this.getMusic().getThumbMediaId());
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class NewsMessage extends WeChatCustomMessage {
    private static final long serialVersionUID = -7401910414232536145L;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Article implements Serializable {

      private static final long serialVersionUID = -7626551509590503096L;
      @JsonProperty
      public String title;
      @JsonProperty
      public String description;
      @JsonProperty
      public String url;
      @JsonProperty("picurl")
      public String picUrl;

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class News implements Serializable {

      private static final long serialVersionUID = 7373319482693569172L;

      @JsonProperty
      private List<Article> articles = new ArrayList<Article>();

    }

    @JsonProperty
    private News news = new News();

    public News getNews() {
      return this.news;
    }

    public void setNews(News news) {
      this.news = news;
    }

    public NewsMessage(List<Article> articles) {
      this.news = new News();
      this.msgType = "news";
      this.news.getArticles().addAll(articles);
    }

    public NewsMessage() {
      this.msgType = "news";
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      NewsMessage news = (NewsMessage) o;

      return Objects.equals(this.getToUser(), news.getToUser())
              && Objects.equals(this.getMsgType(), news.getMsgType())
              && Objects.equals(this.getNews().getArticles().size(),
              news.getNews().getArticles().size());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
              this.getToUser(),
              this.getMsgType(),
              this.getNews().getArticles().size());
    }
  }

}
