package com.ftx.impl;

import com.ftx.constant.FtxApiConstants;
import com.ftx.domain.futures.FundingRate;
import com.ftx.domain.general.Asset;
import com.ftx.domain.market.MarketTicker;
import com.ftx.domain.market.OrderBook;
import com.ftx.domain.market.Trade;
import com.ftx.domain.trading.NewOrder;
import com.ftx.domain.trading.NewOrderResponse;
import com.ftx.domain.trading.OpenOrder;
import com.ftx.domain.Response;
import retrofit2.Call;
import retrofit2.http.*;

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

    @Headers(FtxApiConstants.AUTHORIZATION_REQUIRED_HEADER)
    @POST("/api/orders")
    Call<Response<NewOrderResponse>> placeOrder(@Body NewOrder order);

    @Headers(FtxApiConstants.AUTHORIZATION_REQUIRED_HEADER)
    @DELETE("/api/orders/{orderId}")
    Call<Response<String>> cancelOrder(@Path("orderId") long orderId);

    @Headers(FtxApiConstants.AUTHORIZATION_REQUIRED_HEADER)
    @GET("/api/orders")
    Call<Response<List<OpenOrder>>> getOpenOrders(@Query("market") String market);
}
