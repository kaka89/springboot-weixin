package com.umasuo.wechat.infrastructure.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeChatKeywordData {

  //关键词
  @JsonProperty
  @NotNull
  @Size(min = 1)
  private String keyword;

  //自动回复的内容
  @JsonProperty
  @NotNull
  @Size(min = 1)
  private String content;

  //-1表示没有限制
  @JsonProperty
  private Long startTime;

  //-1表示没有限制
  @JsonProperty
  private Long endTime;

  //1表示可以正常使用，0表示测试组可以使用，-1表示废弃
  @JsonProperty
  private Short status;

  //用于分组测试
  @JsonProperty
  private String visibleToGroups;

  public WeChatKeywordData() {
  }

  public WeChatKeywordData(String keyword, String content, Long startTime, Long endTime,
                           Short status, String visibleToGroups) {
    this.keyword = keyword;
    this.content = content;
    this.startTime = startTime;
    this.status = status;
    this.visibleToGroups = visibleToGroups;
    this.endTime = endTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    WeChatKeywordData other = (WeChatKeywordData) o;

    return Objects.equals(this.getContent(), other.getContent())
            && Objects.equals(this.getEndTime(), other.getEndTime())
            && Objects.equals(this.getStartTime(), other.getStartTime())
            && Objects.equals(this.getStatus(), other.getStatus())
            && Objects.equals(this.getKeyword(), other.getKeyword())
            && Objects.equals(this.getVisibleToGroups(), other.getVisibleToGroups());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
            this.getContent(),
            this.getEndTime(),
            this.getStartTime(),
            this.getStatus(),
            this.getKeyword(),
            this.getVisibleToGroups());
  }
}
