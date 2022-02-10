package io.microanalysis.domain.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market type.
 */
public enum MarketType {

    @JsonProperty("spot")
    SPOT,

    @JsonProperty("future")
    FUTURE
}
