/*
 * Copyright (c) 2014-2015 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.service.zuul.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Custom RequestFilter used for rejecting http requests.
 */
@Component
public class RejectionFilter implements Filter {

    protected static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";

    private static final String[] FORBIDDENE_ENDPOINT = { "/env", "/refresh", "/restart" };
    private static final String[] FORBIDDEN_ENDPOINT_STARTWITH = { "/swagger-ui" };

    private static final Logger logger = LoggerFactory.getLogger(RejectionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            logger.info("request URL {}", httpRequest.getRequestURL().toString());
            String originatingProtocol = httpRequest.getHeader(X_FORWARDED_PROTO);
            logger.info("originatingProtocol {}", originatingProtocol);
            if ("http".equals(originatingProtocol)) {
                logger.error("Http is not allowed!");
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpStatus.SC_BAD_REQUEST);
                httpResponse.getWriter().println("Http is not allowed!");
                return;
            }
            String uri = httpRequest.getRequestURI();
            logger.info("request URI {}", uri);
            for (String endPoint : FORBIDDENE_ENDPOINT) {
                if (endPoint.equalsIgnoreCase(uri)) {
                    logger.error("forbidden endpoint " + uri + "!");
                    HttpServletResponse httpResponse = (HttpServletResponse) response;
                    httpResponse.setStatus(HttpStatus.SC_BAD_REQUEST);
                    httpResponse.getWriter().println("endpoint is not allowed!");
                    return;
                }
            }
            for (String endPoint : FORBIDDEN_ENDPOINT_STARTWITH) {
                if (StringUtils.isNotBlank(uri) && uri.startsWith(endPoint)) {
                    logger.error("forbidden endpoint " + uri + " starts with " + endPoint + "!");
                    HttpServletResponse httpResponse = (HttpServletResponse) response;
                    httpResponse.setStatus(HttpStatus.SC_BAD_REQUEST);
                    httpResponse.getWriter().println("endpoint is not allowed!");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
