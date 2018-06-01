package com.umasuo.wechat.infrastructure.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ByteUtils {

  private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

  private static final String digestAlgorithm = "SHA-1";

  /**
   * Convert byte[] to hex string. 把字节数组转化为字符串
   * 一个字节拆分成两个hex char
   */
  public static String bytesToHexString(byte[] bytes) {
    if (bytes == null || bytes.length == 0) {
      return null;
    }
    char[] hexChars = new char[bytes.length * 2];
    for (int i = 0; i < bytes.length; i++) {
      int index = i << 1;
      int v = bytes[i] & 0xFF;
      hexChars[index] = hexArray[v >>> 4];
      hexChars[index + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
  }

  public static String getHexString(String value)
          throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest md = MessageDigest.getInstance(digestAlgorithm);
    byte[] digest = md.digest(value.getBytes(StandardCharsets.UTF_8));
    return ByteUtils.bytesToHexString(digest);
  }

}
