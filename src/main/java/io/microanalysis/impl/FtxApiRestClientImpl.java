package io.microanalysis.impl;

import io.microanalysis.FtxApiRestClient;
import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;
import io.microanalysis.domain.market.OrderBook;
import io.microanalysis.domain.market.Trade;
import io.microanalysis.domain.trading.NewOrder;
import io.microanalysis.domain.trading.NewOrderResponse;
import io.microanalysis.domain.trading.OpenOrder;

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
