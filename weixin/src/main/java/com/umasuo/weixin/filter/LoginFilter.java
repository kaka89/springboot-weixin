package com.umasuo.weixin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.umasuo.weixin.common.ReturnMessage;

/**
 * 全局的登录filter，用于过滤用户是否已经登录
 * @author umasuo
 *
 */
@Component
public class LoginFilter implements Filter{
    private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void destroy() {
        //do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain nextFilter) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;  
        String url = httpRequest.getRequestURI();
        JSONObject logs = new JSONObject();
        logs.put("url", url);
        logs.put("method", httpRequest.getMethod());
        logs.put("parames", httpRequest.getParameterMap());
        logs.put("queryString", httpRequest.getQueryString());
        logs.put("ip", getIP(httpRequest));
        logs.put("sessionid", httpRequest.getSession().getId());
        logs.put("time", System.currentTimeMillis()/1000);
        
        logger.info(logs.toString());
        if(null!=url && url.equals("/v1/index")){
            //这个接口为微信后段调用接口，不需要进行登录检测，其他接口需要进行登录检测，这里可以根据IP进行过滤，过滤掉非微信后台发送过来的请求
            nextFilter.doFilter(request, response);    
        }else{
            if(this.isLogined(httpRequest)){
                nextFilter.doFilter(request, response);
            }else{
                HttpServletResponse httpResponse = (HttpServletResponse)response;
                //这里改为设置为未登录的状态
                ReturnMessage ret = new ReturnMessage(ReturnMessage.USER_NO_LOGIN_CODE,ReturnMessage.USER_NO_LOGIN_MESSAGE);
                String msg = JSONObject.fromObject(ret).toString();
                httpResponse.getWriter().write(msg);
            }
        }
        
    }
    protected String getIP(HttpServletRequest req) {
        String addr = null;
        String xforword = req.getHeader("X-Forwarded-For");
        if (xforword != null && xforword.length() > 0) {
            logger.debug("found X-Forwarded-For :" + xforword);
            int n = xforword.indexOf(',');
            if (n > -1) {
                addr = xforword.substring(0, n);
            } else {
                addr = xforword;
            }
        } else {
            addr = req.getRemoteAddr();
            logger.debug("not found X-Forwarded-For, use req.getRemoteAddr() : "
                    + addr);
        }
        return addr;
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        //do nothing
    }

    
    private boolean isLogined(HttpServletRequest httpRequest){
        return true;
    }
}
