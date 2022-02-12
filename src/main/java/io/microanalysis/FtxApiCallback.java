package io.microanalysis;

/**
 * This class is used for a non-blocking client.
 *
 * @param <T> the return type from the callback
 */
@FunctionalInterface
public interface FtxApiCallback<T> {

    /**
     * Called whenever a response comes back from the API.
     *
     * @param response the expected response object
     */
    void onResponse(T response);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {
    }
}