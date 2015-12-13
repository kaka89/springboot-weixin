package com.umasuo.weixin.service;

import javax.servlet.http.HttpServletResponse;

import com.umasuo.weixin.common.weixin.message.WeiXinMessage;

/**
 * 
 * <p>class: SubscribeService.java </p>
 * <p>description: com.umasuo.weixin.service </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:23:10
 */
public interface SubscribeService {
    
    public void subscribe(WeiXinMessage msg,HttpServletResponse response);
    
    public void unsubscribe(WeiXinMessage msg,HttpServletResponse response);

}
