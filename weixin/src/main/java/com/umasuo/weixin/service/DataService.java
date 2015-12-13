package com.umasuo.weixin.service;

import javax.servlet.http.HttpServletResponse;

import com.umasuo.weixin.common.weixin.message.WeiXinMessage;

/**
 * 
 * <p>class: DataService.java </p>
 * <p>description: com.umasuo.weixin.service </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:23:50
 */
public interface DataService {

    /**
     * 向特定用户展示其排行版
     * @param msg
     * @param response
     */
    public void showCurrentStep(WeiXinMessage msg,HttpServletResponse response);
}
