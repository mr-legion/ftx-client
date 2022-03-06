package com.ftx.security;

import com.ftx.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * API key.
 */
public class ApiKey {

    private final String value;

    public ApiKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("value", value)
                .toString();
    }
}
