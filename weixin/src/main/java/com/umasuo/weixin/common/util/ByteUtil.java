package com.umasuo.weixin.common.util;

/**
 * 
 * <p>class: ByteUtil.java </p>
 * <p>description: com.umasuo.weixin.common.util </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午1:59:32
 */
public class ByteUtil {
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    /**
     * Convert byte[] to hex string. 把字节数组转化为字符串
     * 一个字节拆分成两个hex char
     * 
     * @param src
     *            byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

//    public static void main(String[] args) {
//        int v = 'G' & 0xFF;
//        System.out.println(v);
//        System.out.println(v >>> 4);
//    }
}
