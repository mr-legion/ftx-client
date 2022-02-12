package io.microanalysis;

import io.microanalysis.impl.*;
import okhttp3.OkHttpClient;

/**
 * A factory for creating FTX API client objects.
 */
public class FtxApiClientFactory {

    private final OkHttpClient client;
    private final FtxApiServiceGenerator serviceGenerator;

    public FtxApiClientFactory() {
        this(new OkHttpClient.Builder().build());
    }

    private FtxApiClientFactory(OkHttpClient client) {
        this.client = client;
        this.serviceGenerator = new FtxApiServiceGenerator(client);
    }

    /**
     * New instance without authentication.
     *
     * @return the FTX API client factory
     */
    public static FtxApiClientFactory newInstance() {
        return new FtxApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public FtxApiRestClient newRestClient() {
        return new FtxApiRestClientImpl(serviceGenerator.createService(FtxApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public FtxApiAsyncRestClient newAsyncRestClient() {
        return new FtxApiAsyncRestClientImpl(serviceGenerator.createService(FtxApiService.class));
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public FtxApiWebSocketClient newWebSocketClient() {
        return new FtxApiWebSocketClientImpl(client);
    }
}
