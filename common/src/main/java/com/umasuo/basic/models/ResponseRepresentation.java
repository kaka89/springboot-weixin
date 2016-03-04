/*
 * Copyright (c) 2015-2016 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.basic.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects.ToStringHelper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRepresentation {

    @ApiModelProperty(value = "response timestamp", required = true)
    @JsonProperty
    private Long timestamp;

    @ApiModelProperty(value = "response status", required = true)
    @JsonProperty
    private int status;

    @ApiModelProperty(value = "response headers", required = true)
    @JsonProperty
    @NotNull
    @Size(min = 1)
    private Map<String, List<String>> headers;

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
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

        ResponseRepresentation other = (ResponseRepresentation) o;

        return Objects.equals(this.getTimestamp(), other.getTimestamp())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getHeaders(), other.getHeaders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getTimestamp(),
                this.getStatus(),
                this.getHeaders());
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    protected ToStringHelper toStringHelper() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("timestamp", this.getTimestamp())
                .add("status", this.getStatus())
                .add("headers", this.getHeaders());
    }
}
