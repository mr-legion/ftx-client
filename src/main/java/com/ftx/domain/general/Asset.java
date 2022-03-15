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
    private boolean fiatMoney;

    private boolean usdFungible;

    /**
     * If the asset is a leveraged token.
     */
    @JsonProperty("isToken")
    private boolean token;

    @JsonProperty("isEtf")
    private boolean etf;

    /**
     * If the asset is used as collateral.
     */
    private boolean collateral;

    private double collateralWeight;

    /**
     * Fast conversion available.
     */
    private boolean convertEnabled;

    private boolean hidden;

    private boolean spotMargin;

    private double indexPrice;

    @JsonProperty("canDeposit")
    private boolean depositEnabled;

    @JsonProperty("canWithdraw")
    private boolean withdrawEnabled;

    /**
     * Cryptocurrency networks (e.g. "omni", "erc20", "trx", "sol").
     */
    @JsonProperty("methods")
    private List<String> networks;

    /**
     * If the network supports the tag.
     */
    private boolean tag;

    private String creditTo;

    private String bep2Asset;
    private String erc20Contract;
    private String trc20Contract;
    private String splMint;

    private boolean nftQuoteCurrencyEligible;

}