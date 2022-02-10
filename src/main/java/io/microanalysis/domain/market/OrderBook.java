package io.microanalysis.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.microanalysis.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Market order book.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {

    private List<Order> asks;
    private List<Order> bids;

    public List<Order> getAsks() {
        return asks;
    }

    public void setAsks(List<Order> asks) {
        this.asks = asks;
    }

    public List<Order> getBids() {
        return bids;
    }

    public void setBids(List<Order> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asks", asks)
                .append("bids", bids)
                .toString();
    }
}
