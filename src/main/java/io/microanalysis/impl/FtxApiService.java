package io.microanalysis.impl;

import io.microanalysis.constant.FtxApiConstants;
import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;
import io.microanalysis.domain.market.OrderBook;
import io.microanalysis.domain.market.Trade;
import io.microanalysis.domain.trading.NewOrder;
import io.microanalysis.domain.trading.NewOrderResponse;
import io.microanalysis.domain.trading.OpenOrder;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static io.microanalysis.constant.FtxApiConstants.AUTHORIZATION_REQUIRED_HEADER;

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

    @GET("/api/markets/{market}/trades")
    Call<Response<List<Trade>>> getTrades(@Path("market") String market,
                                          @Query("start_time") Long startTime,
                                          @Query("end_time") Long endTime);

    @GET("/api/markets/{symbol}/orderbook")
    Call<Response<OrderBook>> getOrderBook(@Path("symbol") String symbol, @Query("depth") Integer limit);

    // Futures endpoints

    @GET("/api/funding_rates")
    Call<Response<List<FundingRate>>> getFundingRates(@Query("future") String future,
                                                      @Query("start_time") Long startTime,
                                                      @Query("end_time") Long endTime);

    // Trading endpoints

    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @POST("/api/orders")
    Call<Response<NewOrderResponse>> placeOrder(@Body NewOrder order);

    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @DELETE("/api/orders/{orderId}")
    Call<Response<String>> cancelOrder(@Path("orderId") long orderId);

    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @GET("/api/orders")
    Call<Response<List<OpenOrder>>> getOpenOrders(@Query("market") String market);
}
