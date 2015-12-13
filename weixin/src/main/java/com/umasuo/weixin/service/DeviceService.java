package com.umasuo.weixin.service;

import javax.servlet.http.HttpServletResponse;

import com.umasuo.weixin.common.weixin.message.WeiXinMessage;

/**
 * 
 * <p>class: DeviceService.java </p>
 * <p>description: com.umasuo.weixin.service </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:23:34
 */
public interface DeviceService {

    /**
     * 回复给设备，协议内容由设备鱼后台一起商定
     * @param msg
     * @param response
     */
    public void answer(WeiXinMessage msg,HttpServletResponse response);
}
