/*
 * Copyright (c) 2015-2016 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.basic.filters;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegister {
    @Bean
    public FilterRegistrationBean filterRegistrationBean0() {

        LogFilter filter = new LogFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("filter0");
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setOrder(100);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
