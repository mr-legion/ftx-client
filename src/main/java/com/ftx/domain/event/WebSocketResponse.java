package com.ftx.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ftx.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Web Socket response.
 *
 * @param <T> payload type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketResponse<T> {

    private String channel;
    private String market;

    private EventType type;

    private Integer code;
    private String msg;

    private T data;

    public WebSocketResponse() {
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
                .append("channel", channel)
                .append("market", market)
                .append("type", type)
                .append("code", code)
                .append("msg", msg)
                .append("data", data)
                .toString();
    }
}
