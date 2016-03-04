/*
 * Copyright (c) 2015-2016 Umasuo, Inc. All Rights Reserved.
 */

package com.umasuo.basic.models.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.umasuo.basic.models.ResponseRepresentation;

/**
 * This class implements a builder for {@link ResponseRepresentation} object.
 */
public class ResponseRepresentationBuilder {

    private Long timestamp;

    private int status;

    private Map<String, List<String>> headers;

    public ResponseRepresentationBuilder timestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ResponseRepresentationBuilder status(int status) {
        this.status = status;
        return this;
    }

    public ResponseRepresentationBuilder headers(Map<String, List<String>> headers) {
        this.headers = headers;
        return this;
    }

    public ResponseRepresentation build() {
        ResponseRepresentation responseRepresentation = new ResponseRepresentation();
        responseRepresentation.setTimestamp(this.timestamp);
        responseRepresentation.setStatus(this.status);
        responseRepresentation.setHeaders(this.headers);
        return responseRepresentation;
    }

    public static ResponseRepresentation createTestModel() {
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("test.headers.key.1", new ArrayList<>());
        headers.get("test.headers.key.1").add("1.1");
        headers.get("test.headers.key.1").add("1.2");
        headers.put("test.headers.key.2", new ArrayList<>());
        headers.get("test.headers.key.2").add("2.1");
        headers.get("test.headers.key.2").add("2.2");
        return new ResponseRepresentationBuilder()
                .timestamp(1110000L)
                .status(403)
                .headers(headers)
                .build();
    }
}
