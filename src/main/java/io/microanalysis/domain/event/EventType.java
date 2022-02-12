package io.microanalysis.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Web socket event type.
 */
public enum EventType {

    @JsonProperty("error")
    ERROR,

    @JsonProperty("subscribed")
    SUBSCRIBED,

    @JsonProperty("unsubscribed")
    UNSUBSCRIBED,

    @JsonProperty("info")
    INFO,

    @JsonProperty("partial")
    PARTIAL,

    @JsonProperty("update")
    UPDATE
}
