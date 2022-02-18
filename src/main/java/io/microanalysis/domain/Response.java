package io.microanalysis.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.microanalysis.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Response wrapper.
 *
 * @param <T> payload type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private boolean success;

    @JsonProperty("result")
    private T data;

    public Response() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("success", success)
                .append("data", data)
                .toString();
    }
}
