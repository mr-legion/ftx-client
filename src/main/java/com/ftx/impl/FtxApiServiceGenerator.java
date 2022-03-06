package com.ftx.impl;

import com.ftx.security.ApiCredentials;
import com.ftx.security.AuthenticationInterceptor;
import com.ftx.FtxApiError;
import com.ftx.exception.FtxApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static com.ftx.constant.FtxApiConstants.API_BASE_URL;

/**
 * Generates a FTX API implementation based on @see {@link FtxApiService}.
 */
public class FtxApiServiceGenerator {

    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, FtxApiError> errorBodyConverter =
            (Converter<ResponseBody, FtxApiError>) converterFactory.responseBodyConverter(
                    FtxApiError.class, new Annotation[0], null);

    private final OkHttpClient client;

    public FtxApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public <S> S createService(Class<S> serviceClass, ApiCredentials apiCredentials) {

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory);

        if (apiCredentials == null) {
            retrofitBuilder.client(client);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor authInterceptor = new AuthenticationInterceptor(apiCredentials);
            OkHttpClient.Builder newBuilder = client.newBuilder();
            newBuilder.interceptors().add(0, authInterceptor);
            OkHttpClient adaptedClient = newBuilder.build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                FtxApiError apiError = getFtxApiError(response);
                throw new FtxApiException(apiError);
            }
        } catch (IOException e) {
            throw new FtxApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static FtxApiError getFtxApiError(Response<?> response) throws IOException, FtxApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}
