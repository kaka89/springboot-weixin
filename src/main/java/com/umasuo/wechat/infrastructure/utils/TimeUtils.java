package com.umasuo.wechat.infrastructure.utils;

public class TimeUtils {
  public static final int DAILY_TIMESTAMP = 86400000;

  public static boolean isUTCStartTime(long timestamp) {
    if (timestamp % DAILY_TIMESTAMP == 0) {
      return true;
    }
    return false;
  }
}
