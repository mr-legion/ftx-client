package io.microanalysis.domain.futures;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.microanalysis.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

import static io.microanalysis.constant.FtxApiConstants.ISO_OFFSET_DATE_TIME_PATTERN;

/**
 * Futures funding rate.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingRate {

    /**
     * Futures name (e.g. BTC-PERP).
     */
    private String future;

    private double rate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO_OFFSET_DATE_TIME_PATTERN)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime time;

    public FundingRate() {
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void addRate(double rate) {
        this.rate += rate;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("future", future)
                .append("rate", rate)
                .append("time", time)
                .toString();
    }
}
