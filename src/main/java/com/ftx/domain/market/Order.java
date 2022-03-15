package com.ftx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order in the order book.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonDeserialize(using = OrderDeserializer.class)
@JsonSerialize(using = OrderSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private double price;
    private double quantity;
}
