package com.ftx.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTickerEvent {

    /**
     * Best ask price if an ask exists, else null.
     */
    private Double ask;

    /**
     * Best bid price if a bid exists, else null.
     */
    private Double bid;

    /**
     * Last trade price if it exists, else null.
     */
    private Double last;

    /**
     * Timestamp in seconds.
     */
    private Long time;

}
