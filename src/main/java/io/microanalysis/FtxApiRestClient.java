package io.microanalysis;

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

/**
 * FTX API facade, supporting synchronous/blocking access FTX's REST API.
 */
public interface FtxApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Response<List<Asset>> getAssets();

    // Market endpoints

    /**
     * Get information about all markets.
     *
     * @return market tickers
     */
    Response<List<MarketTicker>> getMarketTickers();

    /**
     * Get market trades.
     *
     * @param market    symbol of market
     * @param startTime start timestamp in seconds
     * @param endTime   end timestamp in seconds
     * @return market trades
     */
    Response<List<Trade>> getTrades(String market, Long startTime, Long endTime);

    /**
     * Get the order book for the market symbol.
     *
     * @param symbol ticker symbol (e.g. BTC/USDT)
     * @param limit  depth of the order book. Max 100.
     * @return orderbook
     */
    Response<OrderBook> getOrderBook(String symbol, Integer limit);

    // Futures endpoints

    /**
     * Get funding rates.
     *
     * @param future    futures name
     * @param startTime start timestamp in seconds
     * @param endTime   end timestamp in seconds
     * @return funding rates
     */
    Response<List<FundingRate>> getFundingRates(String future, Long startTime, Long endTime);

    // Trading endpoints

    /**
     * Place a new order.
     *
     * @param order the order to submit.
     * @return a response containing details about the newly placed order.
     */
    Response<NewOrderResponse> placeOrder(NewOrder order);

    /**
     * Cancel an active order.
     *
     * @param orderId order ID
     */
    Response<String> cancelOrder(long orderId);

    /**
     * Get user open orders.
     *
     * @param market the market name
     * @return open orders.
     */
    Response<List<OpenOrder>> getOpenOrders(String market);
}