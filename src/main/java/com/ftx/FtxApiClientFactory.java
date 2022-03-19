package com.ftx;

import com.ftx.impl.*;
import com.ftx.security.ApiCredentials;
import okhttp3.OkHttpClient;

/**
 * A factory for creating FTX API client objects.
 */
public class FtxApiClientFactory {

    private final OkHttpClient client;
    private final FtxApiServiceGenerator serviceGenerator;

    private ApiCredentials apiCredentials;

    public FtxApiClientFactory() {
        OkHttpClient client = new OkHttpClient();
        this.client = client;
        this.serviceGenerator = new FtxApiServiceGenerator(client);
    }

    public FtxApiClientFactory(ApiCredentials apiCredentials) {
        OkHttpClient client = new OkHttpClient();
        this.client = client;
        this.serviceGenerator = new FtxApiServiceGenerator(client);
        this.apiCredentials = apiCredentials;
    }

    public FtxApiClientFactory(ApiCredentials apiCredentials, ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiCredentials, apiInteractionConfig);
    }

    public FtxApiClientFactory(OkHttpClient client,
                               ApiCredentials apiCredentials,
                               ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.client = newClient;
        this.serviceGenerator = new FtxApiServiceGenerator(newClient);
        this.apiCredentials = apiCredentials;
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
     * New instance with authentication.
     *
     * @return the FTX API client factory
     */
    public static FtxApiClientFactory newInstance(ApiCredentials apiCredentials) {
        return new FtxApiClientFactory(apiCredentials);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public FtxApiRestClient newRestClient() {
        return new FtxApiRestClientImpl(serviceGenerator.createService(FtxApiService.class, apiCredentials));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public FtxApiAsyncRestClient newAsyncRestClient() {
        return new FtxApiAsyncRestClientImpl(serviceGenerator.createService(FtxApiService.class, apiCredentials));
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public FtxApiWebSocketClient newWebSocketClient() {
        return new FtxApiWebSocketClientImpl(client);
    }
}
