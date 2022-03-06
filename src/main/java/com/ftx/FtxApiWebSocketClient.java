package com.ftx;

import com.ftx.domain.event.MarketTickerEvent;
import com.ftx.domain.event.WebSocketResponse;

import java.io.Closeable;

/**
 * FTX API data streaming facade, supporting streaming of events through web sockets.
 */
public interface FtxApiWebSocketClient {

    /**
     * Open a new web socket to receive {@link MarketTickerEvent} on a callback.
     *
     * @param symbol   of  market to subscribe to
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onMarketTickerEvent(String symbol, FtxApiCallback<WebSocketResponse<MarketTickerEvent>> callback);

}
