package io.microanalysis.impl;

import io.microanalysis.FtxApiRestClient;
import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;

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

    // Market endpoints

    @Override
    public Response<List<MarketTicker>> getMarketTickers() {
        return executeSync(ftxApiService.getMarketTickers());
    }

    // Futures endpoints

    @Override
    public Response<List<FundingRate>> getFundingRates(String future, Long startTime, Long endTime) {
        return executeSync(ftxApiService.getFundingRates(future, startTime, endTime));
    }
}
