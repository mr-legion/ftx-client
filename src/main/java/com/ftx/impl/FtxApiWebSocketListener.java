package com.ftx.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.ftx.FtxApiCallback;
import com.ftx.FtxApiError;
import com.ftx.domain.event.WebSocketRequest;
import com.ftx.domain.event.WebSocketResponse;
import com.ftx.exception.FtxApiException;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;

import static com.ftx.domain.event.EventType.*;

/**
 * FTX API WebSocket listener.
 */
public class FtxApiWebSocketListener<T extends WebSocketResponse<?>> extends WebSocketListener {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final WebSocketRequest request;

    private final FtxApiCallback<T> callback;

    private final ObjectReader objectReader;

    private boolean closing = false;

    public FtxApiWebSocketListener(WebSocketRequest request,
                                   FtxApiCallback<T> callback,
                                   TypeReference<T> eventTypeReference) {
        this.request = request;
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventTypeReference);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        try {
            webSocket.send(mapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        try {

            T event = objectReader.readValue(text);

            if (event.getType() == PARTIAL || event.getType() == UPDATE) {
                callback.onResponse(event);
            } else if (event.getType() == ERROR) {
                throw new FtxApiException(new FtxApiError(false, event.getMsg()));
            }

        } catch (IOException e) {
            throw new FtxApiException(e);
        }
    }

    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (!closing) {
            callback.onFailure(t);
        }
    }
}