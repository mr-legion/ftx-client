package com.ftx.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * An asset FTX supports.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("id")
    private String symbol;

    private String name;

    @JsonProperty("fiat")
    private Boolean fiatMoney;

    private Boolean usdFungible;

    /**
     * If the asset is a leveraged token.
     */
    @JsonProperty("isToken")
    private Boolean token;

    @JsonProperty("isEtf")
    private Boolean etf;

    /**
     * If the asset is used as collateral.
     */
    private Boolean collateral;

    private Double collateralWeight;

    /**
     * Fast conversion available.
     */
    private Boolean convertEnabled;

    private Boolean hidden;

    private Boolean spotMargin;

    private Double indexPrice;

    @JsonProperty("canDeposit")
    private Boolean depositEnabled;

    @JsonProperty("canWithdraw")
    private Boolean withdrawEnabled;

    /**
     * Cryptocurrency networks (e.g. "omni", "erc20", "trx", "sol").
     */
    @JsonProperty("methods")
    private List<String> networks;

    /**
     * If the network supports the tag.
     */
    private Boolean tag;

    private String creditTo;

    private String bep2Asset;
    private String erc20Contract;
    private String trc20Contract;
    private String splMint;

    private Boolean nftQuoteCurrencyEligible;

}