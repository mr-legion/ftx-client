package com.ftx.domain.trading;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ftx.domain.OrderSide;
import com.ftx.domain.OrderStatus;
import com.ftx.domain.OrderType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.ftx.constant.FtxApiConstants.ISO_OFFSET_DATE_TIME_PATTERN_2;

/**
 * Response after placing a new order.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrderResponse {

    private long id;

    private String market;
    private String future;

    private OrderSide side;
    private OrderType type;

    private double price;
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

}