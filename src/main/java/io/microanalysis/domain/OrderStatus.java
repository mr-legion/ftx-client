package io.microanalysis.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Order status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderStatus {

    @JsonProperty("new")
    NEW,

    @JsonProperty("open")
    OPEN,

    @JsonProperty("closed")
    CLOSED
}
