package io.microanalysis.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.microanalysis.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Market information.
 */
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
    private long time;

    public MarketTickerEvent() {
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

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("ask", ask)
                .append("bid", bid)
                .append("last", last)
                .append("time", time)
                .toString();
    }
}
