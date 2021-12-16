package io.microanalysis;

import io.microanalysis.impl.FtxApiRestClientImpl;
import io.microanalysis.impl.FtxApiService;
import io.microanalysis.impl.FtxApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating FTX API client objects.
 */
public class FtxApiClientFactory {

    private final FtxApiServiceGenerator serviceGenerator;

    public FtxApiClientFactory() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        this.serviceGenerator = new FtxApiServiceGenerator(client);
    }

    private FtxApiClientFactory(OkHttpClient client) {
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
}
