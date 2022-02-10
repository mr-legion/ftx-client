package io.microanalysis;

import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;
import io.microanalysis.domain.market.Trade;

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
}