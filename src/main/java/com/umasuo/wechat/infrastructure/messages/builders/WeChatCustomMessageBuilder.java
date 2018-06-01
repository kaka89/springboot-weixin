
package com.umasuo.wechat.infrastructure.messages.builders;


import com.umasuo.wechat.infrastructure.messages.WeChatCustomMessage;

public class WeChatCustomMessageBuilder {

  public static WeChatCustomMessage.TextMessage createTestTextMessage() {
    WeChatCustomMessage.TextMessage text = new WeChatCustomMessage.TextMessage(
            "this is content");
    text.setToUser("QWERTYUIOPASDFGHJKLZXCVBNM");
    return text;
  }

  public static WeChatCustomMessage.ImageMessage createTestImageMessage() {
    WeChatCustomMessage.ImageMessage image = new WeChatCustomMessage.ImageMessage(
            "this is image id.");
    image.setToUser("QWERTYUIOPASDFGHJKLZXCVBNM");
    return image;
  }

  public static WeChatCustomMessage.VideoMessage createTestVideoMessage() {
    WeChatCustomMessage.VideoMessage video = new WeChatCustomMessage.VideoMessage(
            "this is media id.", "this is thumbMediaId", "title", "description");
    video.setToUser("QWERTYUIOPASDFGHJKLZXCVBNM");
    return video;
  }

  public static WeChatCustomMessage.VoiceMessage createTestVoiceMessage() {
    WeChatCustomMessage.VoiceMessage voice = new WeChatCustomMessage.VoiceMessage(
            "this is voice id.");
    voice.setToUser("QWERTYUIOPASDFGHJKLZXCVBNM");
    return voice;
  }

  public static WeChatCustomMessage.MusicMessage createTestMucisMessage() {
    WeChatCustomMessage.MusicMessage music = new WeChatCustomMessage.MusicMessage("title",
            "description", "this is url", "this is hq url", "this is thumb id");
    music.setToUser("QWERTYUIOPASDFGHJKLZXCVBNM");
    return music;
  }

  public static WeChatCustomMessage.NewsMessage createTestNewsMessage() {
    WeChatCustomMessage.NewsMessage news = new WeChatCustomMessage.NewsMessage();
    news.setToUser("QWERTYUIOPASDFGHJKLZXCVBNM");
    return news;
  }
}
