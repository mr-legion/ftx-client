package io.microanalysis.impl;

import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * FTX's REST API URL mappings.
 */
public interface FtxApiService {

    // General endpoints

    @GET("/api/wallet/coins")
    Call<Response<List<Asset>>> getAssets();

    // Market endpoints

    @GET("/api/markets")
    Call<Response<List<MarketTicker>>> getMarketTickers();

    // Futures endpoints

    @GET("/api/funding_rates")
    Call<Response<List<FundingRate>>> getFundingRates(@Query("future") String future,
                                                      @Query("start_time") Long startTime,
                                                      @Query("end_time") Long endTime);

}
