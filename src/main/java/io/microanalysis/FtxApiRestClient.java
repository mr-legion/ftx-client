package io.microanalysis;

import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;

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