/*
 * Copyright (c) 2014-2015 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.service.zuul.models;

public class RedirectRoute {

    private String originalURI;
    private String legacyURI;
    private String newURI;

    public String getOriginalURI() {
        return this.originalURI;
    }

    public void setOriginalURI(String originalURI) {
        this.originalURI = originalURI;
    }

    public String getLegacyURI() {
        return this.legacyURI;
    }

    public void setLegacyURI(String legacyURI) {
        this.legacyURI = legacyURI;
    }

    public String getNewURI() {
        return this.newURI;
    }

    public void setNewURI(String newURI) {
        this.newURI = newURI;
    }

}
