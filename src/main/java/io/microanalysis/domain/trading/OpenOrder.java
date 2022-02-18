package io.microanalysis.domain.trading;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.microanalysis.constant.FtxApiConstants;
import io.microanalysis.domain.OrderSide;
import io.microanalysis.domain.OrderStatus;
import io.microanalysis.domain.OrderType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

import static io.microanalysis.constant.FtxApiConstants.ISO_OFFSET_DATE_TIME_PATTERN_2;

/**
 * Open order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenOrder {

    private long id;

    private String market;
    private String future;

    private OrderSide side;
    private OrderType type;

    private double price;
    private double avgFillPrice;
    private double size;

    private double filledSize;
    private double remainingSize;

    private OrderStatus status;

    private boolean reduceOnly;
    private boolean postOnly;
    private boolean ioc;

    /**
     * Client order id.
     */
    private String clientId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME_PATTERN_2)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    public OpenOrder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAvgFillPrice() {
        return avgFillPrice;
    }

    public void setAvgFillPrice(double avgFillPrice) {
        this.avgFillPrice = avgFillPrice;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getFilledSize() {
        return filledSize;
    }

    public void setFilledSize(double filledSize) {
        this.filledSize = filledSize;
    }

    public double getRemainingSize() {
        return remainingSize;
    }

    public void setRemainingSize(double remainingSize) {
        this.remainingSize = remainingSize;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("market", market)
                .append("future", future)
                .append("side", side)
                .append("type", type)
                .append("price", price)
                .append("avgFillPrice", avgFillPrice)
                .append("size", size)
                .append("filledSize", filledSize)
                .append("remainingSize", remainingSize)
                .append("status", status)
                .append("reduceOnly", reduceOnly)
                .append("postOnly", postOnly)
                .append("ioc", ioc)
                .append("clientId", clientId)
                .append("createdAt", createdAt)
                .toString();
    }
}