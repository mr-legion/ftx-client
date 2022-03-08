package com.ftx.security;

import com.ftx.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * API authentication information.
 */
public class ApiCredentials {

    private final String apiKey;
    private final String secret;

    private String subAccountName;

    public ApiCredentials(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    public ApiCredentials(String apiKey, String secret, String subAccountName) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.subAccountName = subAccountName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecret() {
        return secret;
    }

    public String getSubAccountName() {
        return subAccountName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("apiKey", apiKey)
                .append("secret", "****")
                .append("subAccountName", subAccountName)
                .toString();
    }
}
