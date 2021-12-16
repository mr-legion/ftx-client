package io.microanalysis;

import io.microanalysis.domain.Response;
import io.microanalysis.domain.general.Asset;

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
}