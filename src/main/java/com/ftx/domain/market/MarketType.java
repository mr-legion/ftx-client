package com.ftx.domain.market;

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
