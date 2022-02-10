package io.microanalysis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Order type.
 */
public enum OrderSide {

    @JsonProperty("buy")
    BUY,

    @JsonProperty("sell")
    SELL
}
