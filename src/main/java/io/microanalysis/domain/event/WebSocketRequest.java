package io.microanalysis.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.microanalysis.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Web socket request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketRequest {

    private String channel;
    private String market;

    @JsonProperty("op")
    private RequestType type;

    public WebSocketRequest() {
    }

    public WebSocketRequest(String channel, String market, RequestType type) {
        this.channel = channel;
        this.market = market;
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("channel", channel)
                .append("market", market)
                .append("type", type)
                .toString();
    }
}
