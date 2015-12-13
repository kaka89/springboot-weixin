package com.umasuo.weixin.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * <p>class: TimeUtil.java </p>
 * <p>description: com.umasuo.weixin.common.util </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午1:59:44
 */
public class TimeUtil {

    public static long getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime().getTime();
    }

    public static Long getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime().getTime();
    }

    public static String getDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        java.util.Date dt = new Date(time * 1000);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08:00
        return sDateTime;
    }
    
//    public static void main(String[] args) {
//        System.out.println(TimeUtil.getStartTime());
//    }
}
