package com.umasuo.weixin.service;

import javax.servlet.http.HttpServletResponse;

import com.umasuo.weixin.common.weixin.message.WeiXinMessage;



/**
 * 
 * <p>class: BindsService.java </p>
 * <p>description: com.umasuo.weixin.service </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:24:09
 */
public interface BindsService {
    public void bindDevice(WeiXinMessage msg,HttpServletResponse response);
    public void unbindDevice(WeiXinMessage msg,HttpServletResponse response);
}
