package io.microanalysis.impl;

import io.microanalysis.FtxApiError;
import io.microanalysis.exception.FtxApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static io.microanalysis.impl.FtxApiServiceGenerator.getFtxApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                FtxApiError apiError = getFtxApiError(response);
                onFailure(call, new FtxApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new FtxApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof FtxApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new FtxApiException(t));
        }
    }
}
