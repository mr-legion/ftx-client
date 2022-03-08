package com.ftx.security;

import com.google.common.net.UrlEscapers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Instant;

import static com.ftx.constant.FtxApiConstants.*;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final ApiCredentials apiCredentials;

    public AuthenticationInterceptor(ApiCredentials apiCredentials) {
        this.apiCredentials = apiCredentials;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isApiKeyRequired = original.header(AUTHORIZATION_REQUIRED) != null;
        newRequestBuilder.removeHeader(AUTHORIZATION_REQUIRED);

        // Endpoint requires sending a valid API-KEY
        if (isApiKeyRequired) {

            long timestamp = Instant.now().toEpochMilli();

            String payload = timestamp + original.method() + original.url().encodedPath();

            if (original.url().encodedQuery() != null) {
                payload += "?" + original.url().encodedQuery();
            }

            if (original.method().equals("POST")) {
                payload += bodyToString(original.body());
            }

            String signature = HmacSHA256Signer.sign(payload, apiCredentials.getSecret());

            newRequestBuilder.addHeader(API_KEY_HEADER, apiCredentials.getApiKey());
            newRequestBuilder.addHeader(API_SIGN_HEADER, signature);
            newRequestBuilder.addHeader(API_TIMESTAMP_HEADER, String.valueOf(timestamp));

            if (!StringUtils.isEmpty(apiCredentials.getSubAccountName())) {
                String encodedName = UrlEscapers.urlFragmentEscaper().escape(apiCredentials.getSubAccountName());
                newRequestBuilder.addHeader(API_SUB_ACCOUNT_HEADER, encodedName);
            }

            newRequestBuilder.tag(String.class, apiCredentials.getApiKey());
        }

        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    private static String bodyToString(RequestBody request) {
        try (final Buffer buffer = new Buffer()) {
            if (request != null) {
                request.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}