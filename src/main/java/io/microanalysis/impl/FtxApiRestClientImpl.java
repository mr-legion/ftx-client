package io.microanalysis.impl;

import io.microanalysis.FtxApiRestClient;
import io.microanalysis.domain.Response;
import io.microanalysis.domain.general.Asset;

import java.util.List;

import static io.microanalysis.impl.FtxApiServiceGenerator.executeSync;

/**
 * Implementation of FTX's REST API using Retrofit with synchronous/blocking method calls.
 */
public class FtxApiRestClientImpl implements FtxApiRestClient {

    private final FtxApiService ftxApiService;

    public FtxApiRestClientImpl(FtxApiService ftxApiService) {
        this.ftxApiService = ftxApiService;
    }

    // General endpoints

    @Override
    public Response<List<Asset>> getAssets() {
        return executeSync(ftxApiService.getAssets());
    }
}
