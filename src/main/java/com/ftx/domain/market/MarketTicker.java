package com.ftx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    /**
     * Market symbol (e.g. "BTC/USD" for spot, "BTC-PERP" for futures).
     */
    @JsonProperty("name")
    private String symbol;

    /**
     * Spot markets only.
     */
    @JsonProperty("baseCurrency")
    private String baseAssetSymbol;

    /**
     * Spot markets only.
     */
    @JsonProperty("quoteCurrency")
    private String quoteAssetSymbol;

    /**
     * The underlying asset on the futures.
     */
    @JsonProperty("underlying")
    private String underlyingAsset;

    private MarketType type;

    private Boolean enabled;

    /**
     * If the market is in post-only mode
     * (all orders get modified to be post-only, in addition to other settings they may have).
     */
    private Boolean postOnly;

    /**
     * If the market has nonstandard restrictions on which jurisdictions can trade it.
     */
    private Boolean restricted;
    private Boolean highLeverageFeeExempt;

    /**
     * Current price.
     */
    private Double price;

    /**
     * Last traded price.
     */
    private Double last;

    /**
     * Best ask.
     */
    private Double ask;

    /**
     * Best bid.
     */
    private Double bid;

    private Double priceIncrement;
    private Double sizeIncrement;

    /**
     * Minimum maker order size (if >10 orders per hour fall below this size).
     */
    private Double minProvideSize;
    private Double largeOrderThreshold;

    /**
     * Change in the past hour.
     */
    private Double change1h;

    /**
     * Change in the past 24 hours.
     */
    private Double change24h;

    /**
     * Change since start of day (00:00 UTC).
     */
    private Double changeBod;

    private Double quoteVolume24h;

    /**
     * USD volume in past 24 hours.
     */
    private Double volumeUsd24h;

}
