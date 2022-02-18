package io.microanalysis.domain.trading;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.microanalysis.constant.FtxApiConstants;
import io.microanalysis.domain.OrderSide;
import io.microanalysis.domain.OrderType;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * New order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrder {

    /**
     * Market name (e.g. "BTC/USD" for spot, "XRP-PERP" for futures).
     */
    @JsonProperty("market")
    private String market;

    /**
     * Send null for market orders.
     */
    private Double price;

    @JsonProperty("size")
    private double quantity;

    private OrderSide side;
    private OrderType type;

    private boolean reduceOnly;
    private boolean postOnly;
    private boolean ioc;

    /**
     * Client order id.
     */
    private String clientId;

    public NewOrder() {
    }

    public NewOrder(String market, Double price, double quantity, OrderSide side, OrderType type) {
        this.market = market;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.type = type;
    }

    public NewOrder(String market, Double price, double quantity, OrderSide side, OrderType type,
                    boolean reduceOnly, boolean postOnly, boolean ioc, String clientId) {
        this.market = market;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.type = type;
        this.reduceOnly = reduceOnly;
        this.postOnly = postOnly;
        this.ioc = ioc;
        this.clientId = clientId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public boolean isReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public boolean isIoc() {
        return ioc;
    }

    public void setIoc(boolean ioc) {
        this.ioc = ioc;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("market", market)
                .append("price", price)
                .append("quantity", quantity)
                .append("side", side)
                .append("type", type)
                .append("reduceOnly", reduceOnly)
                .append("postOnly", postOnly)
                .append("ioc", ioc)
                .append("clientId", clientId)
                .toString();
    }
}