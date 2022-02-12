package io.microanalysis;

import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;
import io.microanalysis.domain.market.OrderBook;
import io.microanalysis.domain.market.Trade;

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
}