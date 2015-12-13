package com.umasuo.weixin.service;

import javax.servlet.http.HttpServletResponse;

import com.umasuo.weixin.common.weixin.message.WeiXinMessage;

/**
 * 
 * <p>class: RankService.java </p>
 * <p>description: com.umasuo.weixin.service </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:23:28
 */
public interface RankService {

    /**
     * show wechat rank to user
     */
    public void showRank(WeiXinMessage msg,HttpServletResponse response);
}
