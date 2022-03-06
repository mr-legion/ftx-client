package com.ftx.impl;

import com.ftx.FtxApiAsyncRestClient;
import com.ftx.domain.market.MarketTicker;
import com.ftx.domain.Response;
import com.ftx.domain.futures.FundingRate;
import com.ftx.domain.general.Asset;
import com.ftx.domain.market.OrderBook;
import com.ftx.domain.market.Trade;
import com.ftx.domain.trading.NewOrder;
import com.ftx.domain.trading.NewOrderResponse;
import com.ftx.domain.trading.OpenOrder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of FTX's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class FtxApiAsyncRestClientImpl implements FtxApiAsyncRestClient {

    private final FtxApiService ftxApiService;

    public FtxApiAsyncRestClientImpl(FtxApiService ftxApiService) {
        this.ftxApiService = ftxApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Response<List<Asset>>> getAssets() {
        CompletableFuture<Response<List<Asset>>> future = new CompletableFuture<>();
        ftxApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<Response<List<MarketTicker>>> getMarketTickers() {
        CompletableFuture<Response<List<MarketTicker>>> future = new CompletableFuture<>();
        ftxApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<List<Trade>>> getTrades(String market, Long startTime, Long endTime) {
        CompletableFuture<Response<List<Trade>>> future = new CompletableFuture<>();
        ftxApiService.getTrades(market, startTime, endTime).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<OrderBook>> getOrderBook(String symbol, Integer limit) {
        CompletableFuture<Response<OrderBook>> future = new CompletableFuture<>();
        ftxApiService.getOrderBook(symbol, limit).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Futures endpoints

    @Override
    public CompletableFuture<Response<List<FundingRate>>> getFundingRates(String future, Long startTime, Long endTime) {
        CompletableFuture<Response<List<FundingRate>>> completableFuture = new CompletableFuture<>();
        ftxApiService.getFundingRates(future, startTime, endTime).enqueue(new RetrofitCallbackAdapter<>(completableFuture));
        return completableFuture;
    }

    // Trading endpoints

    @Override
    public CompletableFuture<Response<NewOrderResponse>> placeOrder(NewOrder order) {
        CompletableFuture<Response<NewOrderResponse>> future = new CompletableFuture<>();
        ftxApiService.placeOrder(order).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<String>> cancelOrder(long orderId) {
        CompletableFuture<Response<String>> future = new CompletableFuture<>();
        ftxApiService.cancelOrder(orderId).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<List<OpenOrder>>> getOpenOrders(String market) {
        CompletableFuture<Response<List<OpenOrder>>> future = new CompletableFuture<>();
        ftxApiService.getOpenOrders(market).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
