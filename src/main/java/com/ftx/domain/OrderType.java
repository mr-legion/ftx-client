package com.ftx.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Order type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderType {

    @JsonProperty("limit")
    LIMIT,

    @JsonProperty("market")
    MARKET
}
