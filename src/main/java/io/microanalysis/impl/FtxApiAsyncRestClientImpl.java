package io.microanalysis.impl;

import io.microanalysis.FtxApiAsyncRestClient;
import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;
import io.microanalysis.domain.market.OrderBook;
import io.microanalysis.domain.market.Trade;

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
}
