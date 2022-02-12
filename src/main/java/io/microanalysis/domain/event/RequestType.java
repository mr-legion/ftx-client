package io.microanalysis.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Web socket request type.
 */
public enum RequestType {

    @JsonProperty("subscribe")
    SUBSCRIBE,

    @JsonProperty("unsubscribe")
    UNSUBSCRIBE
}
