/*
 * Copyright (c) 2015-2016 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.basic.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umasuo.basic.models.RequestRepresentation;
import com.umasuo.basic.models.ResponseRepresentation;


//@Configuration
public class LogFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    /**
     * set the url patterns for this filter
     * @param authFilter
     * @return
     */

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        logger.info(toString(httpRequest));
        chain.doFilter(request, response);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        logger.info(toString(httpResponse));
    }

    @Override
    public void destroy() {
    }

    /**
     * get request information
     * @param request
     * @return
     */
    protected String toString(HttpServletRequest request) {
        RequestRepresentation rp = new RequestRepresentation();
        rp.setTimestamp(System.currentTimeMillis());
        rp.setMethod(RequestMethod.valueOf(request.getMethod()));
        rp.setPath(request.getServletPath());
        rp.setHeaders(getRequestHeaders(request));
        rp.setParameterMap(getRequestParameterMap(request));
        return rp.toString();
    }

    /**
     * get request body
     * @param request
     * @return
     * @throws IOException
     */
    protected String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder msg = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        reader.mark(10000);
        try {
            while ((line = reader.readLine()) != null) {
                msg.append(line);
            }
        } finally {
            reader.reset();
            reader.close();
        }
        return msg.toString();
    }

    /**
     * @param response
     * @return
     */
    protected String toString(HttpServletResponse response) {
        ResponseRepresentation rp = new ResponseRepresentation();
        rp.setTimestamp(System.currentTimeMillis());
        rp.setStatus(response.getStatus());
        rp.setHeaders(getResponseHeaders(response));
        return rp.toString();
    }

    /**
     * get request headers
     * @param request
     * @return
     */
    private Map<String, List<String>> getRequestHeaders(HttpServletRequest request) {
        Map<String, List<String>> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                headers.put(name, new ArrayList<String>());
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    headers.get(name).add(value);
                }
            }
        }
        return headers;
    }

    /**
     * get request parameterMap
     * @param request
     * @return
     */
    private Map<String, List<String>> getRequestParameterMap(HttpServletRequest request) {
        Map<String, String[]> paramsFromRequest = request.getParameterMap();
        Map<String, List<String>> params = new HashMap<>();
        if (paramsFromRequest != null) {
            for (Map.Entry<String, String[]> entry : paramsFromRequest.entrySet()) {
                params.put(entry.getKey(), new ArrayList<String>());
                String[] values = paramsFromRequest.get(entry.getKey());
                for (String value : values) {
                    params.get(entry.getKey()).add(value);
                }
            }
        }
        return params;
    }

    /**
     * get response headers
     * @param request
     * @return
     */
    private Map<String, List<String>> getResponseHeaders(HttpServletResponse response) {
        Map<String, List<String>> headers = new HashMap<>();
        Collection<String> headerNames = response.getHeaderNames();
        if (headerNames != null) {
            for (String header : headerNames) {
                headers.put(header, new ArrayList<String>());
                Collection<String> values = response.getHeaders(header);
                headers.get(header).addAll(values);
            }
        }
        return headers;
    }
}