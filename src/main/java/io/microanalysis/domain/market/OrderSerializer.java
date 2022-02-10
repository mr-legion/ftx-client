package io.microanalysis.domain.market;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Custom serializer for an OrderBookEntry.
 */
public class OrderSerializer extends JsonSerializer<Order> {

    @Override
    public void serialize(Order order, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        gen.writeString(String.valueOf(order.getPrice()));
        gen.writeString(String.valueOf(order.getQuantity()));
        gen.writeEndArray();
    }
}
