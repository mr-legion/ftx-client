package io.microanalysis.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.microanalysis.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Market information.
 */
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

    private boolean enabled;

    /**
     * If the market is in post-only mode
     * (all orders get modified to be post-only, in addition to other settings they may have).
     */
    private boolean postOnly;

    /**
     * If the market has nonstandard restrictions on which jurisdictions can trade it.
     */
    private boolean restricted;
    private boolean highLeverageFeeExempt;

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

    private double priceIncrement;
    private double sizeIncrement;

    /**
     * Minimum maker order size (if >10 orders per hour fall below this size).
     */
    private double minProvideSize;
    private double largeOrderThreshold;

    /**
     * Change in the past hour.
     */
    private double change1h;

    /**
     * Change in the past 24 hours.
     */
    private double change24h;

    /**
     * Change since start of day (00:00 UTC).
     */
    private double changeBod;

    private double quoteVolume24h;

    /**
     * USD volume in past 24 hours.
     */
    private double volumeUsd24h;

    public MarketTicker() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseAssetSymbol() {
        return baseAssetSymbol;
    }

    public void setBaseAssetSymbol(String baseAssetSymbol) {
        this.baseAssetSymbol = baseAssetSymbol;
    }

    public String getQuoteAssetSymbol() {
        return quoteAssetSymbol;
    }

    public void setQuoteAssetSymbol(String quoteAssetSymbol) {
        this.quoteAssetSymbol = quoteAssetSymbol;
    }

    public String getUnderlyingAsset() {
        return underlyingAsset;
    }

    public void setUnderlyingAsset(String underlyingAsset) {
        this.underlyingAsset = underlyingAsset;
    }

    public MarketType getType() {
        return type;
    }

    public void setType(MarketType type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public boolean isHighLeverageFeeExempt() {
        return highLeverageFeeExempt;
    }

    public void setHighLeverageFeeExempt(boolean highLeverageFeeExempt) {
        this.highLeverageFeeExempt = highLeverageFeeExempt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public double getPriceIncrement() {
        return priceIncrement;
    }

    public void setPriceIncrement(double priceIncrement) {
        this.priceIncrement = priceIncrement;
    }

    public double getSizeIncrement() {
        return sizeIncrement;
    }

    public void setSizeIncrement(double sizeIncrement) {
        this.sizeIncrement = sizeIncrement;
    }

    public double getMinProvideSize() {
        return minProvideSize;
    }

    public void setMinProvideSize(double minProvideSize) {
        this.minProvideSize = minProvideSize;
    }

    public double getLargeOrderThreshold() {
        return largeOrderThreshold;
    }

    public void setLargeOrderThreshold(double largeOrderThreshold) {
        this.largeOrderThreshold = largeOrderThreshold;
    }

    public double getChange1h() {
        return change1h;
    }

    public void setChange1h(double change1h) {
        this.change1h = change1h;
    }

    public double getChange24h() {
        return change24h;
    }

    public void setChange24h(double change24h) {
        this.change24h = change24h;
    }

    public double getChangeBod() {
        return changeBod;
    }

    public void setChangeBod(double changeBod) {
        this.changeBod = changeBod;
    }

    public double getQuoteVolume24h() {
        return quoteVolume24h;
    }

    public void setQuoteVolume24h(double quoteVolume24h) {
        this.quoteVolume24h = quoteVolume24h;
    }

    public double getVolumeUsd24h() {
        return volumeUsd24h;
    }

    public void setVolumeUsd24h(double volumeUsd24h) {
        this.volumeUsd24h = volumeUsd24h;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("baseAssetSymbol", baseAssetSymbol)
                .append("quoteAssetSymbol", quoteAssetSymbol)
                .append("underlyingAsset", underlyingAsset)
                .append("type", type)
                .append("enabled", enabled)
                .append("postOnly", postOnly)
                .append("restricted", restricted)
                .append("highLeverageFeeExempt", highLeverageFeeExempt)
                .append("price", price)
                .append("last", last)
                .append("ask", ask)
                .append("bid", bid)
                .append("priceIncrement", priceIncrement)
                .append("sizeIncrement", sizeIncrement)
                .append("minProvideSize", minProvideSize)
                .append("largeOrderThreshold", largeOrderThreshold)
                .append("change1h", change1h)
                .append("change24h", change24h)
                .append("changeBod", changeBod)
                .append("quoteVolume24h", quoteVolume24h)
                .append("volumeUsd24h", volumeUsd24h)
                .toString();
    }
}
