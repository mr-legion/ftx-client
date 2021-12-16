package io.microanalysis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.microanalysis.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * FTX API error.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FtxApiError {

    private boolean success;

    @JsonProperty("error")
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("success", success)
                .append("msg", msg)
                .toString();
    }
}
