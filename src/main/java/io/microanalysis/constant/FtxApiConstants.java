package io.microanalysis.constant;

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
     * Default ToStringStyle used by toString methods.
     */
    public static final ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
