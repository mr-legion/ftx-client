package com.ftx.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * API authentication information.
 */
@Getter
@ToString(exclude = "secret")
@EqualsAndHashCode
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
}
