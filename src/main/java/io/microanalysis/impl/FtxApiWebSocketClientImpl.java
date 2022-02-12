package io.microanalysis.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.microanalysis.FtxApiCallback;
import io.microanalysis.FtxApiWebSocketClient;
import io.microanalysis.domain.event.MarketTickerEvent;
import io.microanalysis.domain.event.WebSocketRequest;
import io.microanalysis.domain.event.WebSocketResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.io.Closeable;

import static io.microanalysis.constant.FtxApiConstants.STREAM_API_BASE_URL;
import static io.microanalysis.domain.event.RequestType.SUBSCRIBE;

/**
 * FTX API WebSocket client implementation using OkHttp.
 */
public class FtxApiWebSocketClientImpl implements FtxApiWebSocketClient {

    private final OkHttpClient client;

    public FtxApiWebSocketClientImpl(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public Closeable onMarketTickerEvent(String symbol, FtxApiCallback<WebSocketResponse<MarketTickerEvent>> callback) {
        WebSocketRequest request = new WebSocketRequest("ticker", symbol, SUBSCRIBE);
        return createNewWebSocket(new FtxApiWebSocketListener<>(
                request, callback, new TypeReference<>() {}
        ));
    }

    private Closeable createNewWebSocket(FtxApiWebSocketListener<?> listener) {
        Request request = new Request.Builder().url(STREAM_API_BASE_URL).build();
        final WebSocket webSocket = client.newWebSocket(request, listener);
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, "close");
        };
    }
}
