package com.umasuo.weixin.dao;

import java.util.List;
import java.util.Map;

import com.umasuo.weixin.vo.WeiXinUser;

/**
 * 
 * <p>interface: WeiXinUserDao.java </p>
 * <p>description: com.umasuo.weixin.dao </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:41:04
 */
public interface WeiXinUserDao {

	/**
	 * 
	 * @param
	 * @return
	 */
	public WeiXinUser getLatestUserByWxid(String wxid);
	
	public WeiXinUser getLatestUserByOpenid(String openid);

}
