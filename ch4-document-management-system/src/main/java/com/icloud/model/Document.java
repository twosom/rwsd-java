package com.icloud.model;

import java.util.Map;

public record Document(Map<String, String> attributes) {

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
