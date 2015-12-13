package com.umasuo.weixin.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umasuo.weixin.common.config.AppConfig;
import com.umasuo.weixin.dao.WeiXinUserDao;
import com.umasuo.weixin.vo.WeiXinUser;

/**
 * 
 * <p>class: WeiXinUserDaoImpl.java </p>
 * <p>description: com.umasuo.weixin.dao.impl </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:40:51
 */
@Service
public class WeiXinUserDaoImpl implements WeiXinUserDao {

	private static Logger logger = LoggerFactory.getLogger(WeiXinUserDaoImpl.class);
	static final Class<WeiXinUser> entityClass = WeiXinUser.class;
	@Autowired
	public AppConfig appConfig;

    @Override
    public WeiXinUser getLatestUserByWxid(String wxid) {
        return null;
    }

    @Override
    public WeiXinUser getLatestUserByOpenid(String openid) {
        return null;
    }
    
}
