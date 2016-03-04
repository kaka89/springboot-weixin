/*
 * Copyright (c) 2015-2016 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.basic.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects.ToStringHelper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestRepresentation {

    @ApiModelProperty(value = "request timestamp", required = true)
    @JsonProperty
    private long timestamp;

    @ApiModelProperty(value = "request method", required = true)
    @JsonProperty
    @NotNull
    private RequestMethod method;

    @ApiModelProperty(value = "request path", required = true)
    @JsonProperty
    @NotNull
    private String path;

    @ApiModelProperty(value = "request headers", required = true)
    @JsonProperty
    @NotNull
    @Size(min = 1)
    private Map<String, List<String>> headers;

    @ApiModelProperty(value = "request parameterMap", required = true)
    @JsonProperty
    @NotNull
    Map<String, List<String>> parameterMap;

    public Map<String, List<String>> getParameterMap() {
        return this.parameterMap;
    }

    public void setParameterMap(Map<String, List<String>> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public RequestMethod getMethod() {
        return this.method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RequestRepresentation other = (RequestRepresentation) o;

        return Objects.equals(this.getTimestamp(), other.getTimestamp())
                && Objects.equals(this.getMethod(), other.getMethod())
                && Objects.equals(this.getPath(), other.getPath())
                && Objects.equals(this.getHeaders(), other.getHeaders())
                && Objects.equals(this.getParameterMap(), other.getParameterMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getTimestamp(),
                this.getMethod(),
                this.getPath(),
                this.getHeaders(),
                this.getParameterMap());
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    protected ToStringHelper toStringHelper() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("timestamp", this.getTimestamp())
                .add("method", this.getMethod())
                .add("path", this.getPath())
                .add("headers", this.getHeaders())
                .add("parameterMap", this.getParameterMap());
    }

}
