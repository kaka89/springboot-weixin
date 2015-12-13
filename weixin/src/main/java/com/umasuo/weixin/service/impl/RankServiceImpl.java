package com.umasuo.weixin.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.umasuo.weixin.common.weixin.message.WeiXinMessage;
import com.umasuo.weixin.common.weixin.message.WeiXinResponse;
import com.umasuo.weixin.service.RankService;

/**
 * 
 * <p>class: RankServiceImpl.java </p>
 * <p>description: com.umasuo.weixin.service.impl </p>
 * @author umasuo
 * @email  liuquan89@gmail.com
 * @date   2015年12月14日 下午2:25:23
 */
@Service
public class RankServiceImpl implements RankService{

    private static Logger logger = LoggerFactory.getLogger(RankServiceImpl.class);
    
    @Override
    public void showRank(WeiXinMessage msg,HttpServletResponse response) {
        WeiXinResponse.HardwareResponse retMsg = new WeiXinResponse.HardwareResponse();
        retMsg.ToUserName = msg.FromUserName;
        retMsg.FromUserName = msg.ToUserName;
        String ret = retMsg.build();
        logger.info("weixin rank. " + ret);
        try {
            response.getWriter().write(ret);
        } catch (IOException e) {
            logger.info("weixin rank step. error .ret:" + ret + ", " + e.getMessage());
            e.printStackTrace();
        }
    }

}
