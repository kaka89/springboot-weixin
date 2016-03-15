/*
 * Copyright (c) 2014-2015 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.service.zuul.configurations;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.umasuo.service.zuul.models.RedirectRoute;

@Configuration
@ConfigurationProperties
public class RedirectRoutesConfig {

    private List<RedirectRoute> redirectRoutes;

    public List<RedirectRoute> getRedirectRoutes() {
        return this.redirectRoutes;
    }

    public void setRedirectRoutes(List<RedirectRoute> redirectRoutes) {
        this.redirectRoutes = redirectRoutes;
    }

}
