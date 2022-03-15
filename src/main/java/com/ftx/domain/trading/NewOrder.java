package com.ftx.domain.trading;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftx.domain.OrderSide;
import com.ftx.domain.OrderType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * New order.
 */
@NoArgsConstructor
@Data
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

    public NewOrder(String market, Double price, double quantity, OrderSide side, OrderType type) {
        this.market = market;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.type = type;
    }

}