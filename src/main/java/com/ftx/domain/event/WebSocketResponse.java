package com.ftx.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Web Socket response.
 *
 * @param <T> payload type
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketResponse<T> {

    private String channel;
    private String market;

    private EventType type;

    private Integer code;
    private String msg;

    private T data;

}
