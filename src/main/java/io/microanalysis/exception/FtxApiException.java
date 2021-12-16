package io.microanalysis.exception;

import io.microanalysis.FtxApiError;

/**
 * An exception which can occur while invoking methods of the FTX API.
 */
public class FtxApiException extends RuntimeException {

    private static final long serialVersionUID = -808896203401431950L;

    private FtxApiError error;

    public FtxApiException(FtxApiError error) {
        this.error = error;
    }

    public FtxApiException() {
        super();
    }

    public FtxApiException(String message) {
        super(message);
    }

    public FtxApiException(Throwable cause) {
        super(cause);
    }

    public FtxApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from FTX API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public FtxApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
