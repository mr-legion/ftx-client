package com.ftx.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout FTX's API.
 */
public final class FtxApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "ftx.com";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://" + BASE_DOMAIN;

    /**
     * Streaming API base URL.
     */
    public static final String STREAM_API_BASE_URL = String.format("wss://%s/ws", BASE_DOMAIN);

    /**
     * ISO offset date time pattern.
     */
    public static final String ISO_OFFSET_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX";

    /**
     * ISO offset date time pattern with milliseconds.
     */
    public static final String ISO_OFFSET_DATE_TIME_PATTERN_2 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX";

    /**
     * HTTP Headers to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "FTX-KEY";
    public static final String API_SIGN_HEADER = "FTX-SIGN";
    public static final String API_TIMESTAMP_HEADER = "FTX-TS";
    public static final String API_SUB_ACCOUNT_HEADER = "FTX-SUBACCOUNT";

    /**
     * Decorator to indicate that an endpoint requires authorization.
     */
    public static final String AUTHORIZATION_REQUIRED = "AUTHORIZATION";
    public static final String AUTHORIZATION_REQUIRED_HEADER = AUTHORIZATION_REQUIRED + ": #";

    /**
     * Default ToStringStyle used by toString methods.
     */
    public static final ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
