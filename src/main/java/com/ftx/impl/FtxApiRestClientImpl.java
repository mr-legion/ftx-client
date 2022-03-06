package com.ftx.impl;

import com.ftx.domain.general.Asset;
import com.ftx.domain.market.MarketTicker;
import com.ftx.domain.market.OrderBook;
import com.ftx.domain.market.Trade;
import com.ftx.domain.trading.NewOrder;
import com.ftx.domain.trading.NewOrderResponse;
import com.ftx.domain.trading.OpenOrder;
import com.ftx.FtxApiRestClient;
import com.ftx.domain.Response;
import com.ftx.domain.futures.FundingRate;

import java.util.List;

import static com.ftx.impl.FtxApiServiceGenerator.executeSync;

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

    @Override
    public Response<List<Trade>> getTrades(String market, Long startTime, Long endTime) {
        return executeSync(ftxApiService.getTrades(market, startTime, endTime));
    }

    @Override
    public Response<OrderBook> getOrderBook(String symbol, Integer limit) {
        return executeSync(ftxApiService.getOrderBook(symbol, limit));
    }

    // Futures endpoints

    @Override
    public Response<List<FundingRate>> getFundingRates(String future, Long startTime, Long endTime) {
        return executeSync(ftxApiService.getFundingRates(future, startTime, endTime));
    }

    // Trading endpoints

    @Override
    public Response<NewOrderResponse> placeOrder(NewOrder order) {
        return executeSync(ftxApiService.placeOrder(order));
    }

    @Override
    public Response<String> cancelOrder(long orderId) {
        return executeSync(ftxApiService.cancelOrder(orderId));
    }

    @Override
    public Response<List<OpenOrder>> getOpenOrders(String market) {
        return executeSync(ftxApiService.getOpenOrders(market));
    }
}
