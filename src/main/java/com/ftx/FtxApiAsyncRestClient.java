package com.ftx;

import com.ftx.domain.Response;
import com.ftx.domain.futures.FundingRate;
import com.ftx.domain.general.Asset;
import com.ftx.domain.market.MarketTicker;
import com.ftx.domain.market.OrderBook;
import com.ftx.domain.market.Trade;
import com.ftx.domain.trading.NewOrder;
import com.ftx.domain.trading.NewOrderResponse;
import com.ftx.domain.trading.OpenOrder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * FTX API facade, supporting asynchronous/non-blocking access FTX's REST API.
 */
public interface FtxApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Response<List<Asset>>> getAssets();

    // Market endpoints

    /**
     * Get information about all markets (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Response<List<MarketTicker>>> getMarketTickers();

    /**
     * Get market trades (asynchronous).
     *
     * @param market    symbol of market
     * @param startTime start timestamp in seconds
     * @param endTime   end timestamp in seconds
     * @return market trades
     */
    CompletableFuture<Response<List<Trade>>> getTrades(String market, Long startTime, Long endTime);

    /**
     * Get the order book for the market symbol (asynchronous).
     *
     * @param symbol ticker symbol (e.g. BTC/USDT)
     * @param limit  depth of the order book. Max 100.
     * @return orderbook
     */
    CompletableFuture<Response<OrderBook>> getOrderBook(String symbol, Integer limit);

    // Futures endpoints

    /**
     * Get funding rates (asynchronous).
     *
     * @param future    futures name
     * @param startTime start timestamp in seconds
     * @param endTime   end timestamp in seconds
     * @return funding rates
     */
    CompletableFuture<Response<List<FundingRate>>> getFundingRates(String future, Long startTime, Long endTime);

    // Trading endpoints

    // Trading endpoints

    /**
     * Place a new order (asynchronous).
     *
     * @param order the order to submit.
     * @return a response containing details about the newly placed order.
     */
    CompletableFuture<Response<NewOrderResponse>> placeOrder(NewOrder order);

    /**
     * Cancel an active order (asynchronous).
     *
     * @param orderId order ID
     */
    CompletableFuture<Response<String>> cancelOrder(long orderId);

    /**
     * Get user open orders (asynchronous).
     *
     * @param market the market name
     * @return open orders.
     */
    CompletableFuture<Response<List<OpenOrder>>> getOpenOrders(String market);
}