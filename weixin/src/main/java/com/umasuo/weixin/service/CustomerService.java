package com.umasuo.weixin.service;

import javax.servlet.http.HttpServletResponse;

import com.umasuo.weixin.common.weixin.message.WeiXinMessage;

/**
 * 
 * <p>class: CustomerService.java </p>
 * <p>description: com.umasuo.weixin.service </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:24:00
 */
public interface CustomerService {
    
    /**
     * 回复信息给用户，根据关键字表来自动回复，或者转发给客服来进行回复
     * @param msg
     * @param response
     */
    public void answer(WeiXinMessage msg,HttpServletResponse response);

}
