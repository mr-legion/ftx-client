package io.microanalysis.domain.market;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.microanalysis.constant.FtxApiConstants;
import io.microanalysis.domain.OrderSide;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

import static io.microanalysis.constant.FtxApiConstants.ISO_OFFSET_DATE_TIME_PATTERN_2;

/**
 * An executed trade.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade {

    private long id;

    private double price;

    @JsonProperty("size")
    private double quantity;

    private OrderSide side;

    /**
     * If this trade involved a liquidation order.
     */
    private boolean liquidation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME_PATTERN_2)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(double quantity) {
        this.quantity += quantity;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public boolean isLiquidation() {
        return liquidation;
    }

    public void setLiquidation(boolean liquidation) {
        this.liquidation = liquidation;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("price", price)
                .append("quantity", quantity)
                .append("side", side)
                .append("liquidation", liquidation)
                .append("time", time)
                .toString();
    }
}
