package io.microanalysis.impl;

import io.microanalysis.domain.Response;
import io.microanalysis.domain.general.Asset;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * FTX's REST API URL mappings.
 */
public interface FtxApiService {

    // General endpoints

    @GET("/api/wallet/coins")
    Call<Response<List<Asset>>> getAssets();

}
