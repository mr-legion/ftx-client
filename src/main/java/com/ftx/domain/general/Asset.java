package com.ftx.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftx.constant.FtxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * An asset FTX supports.
 */
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

    public Asset() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFiatMoney() {
        return fiatMoney;
    }

    public void setFiatMoney(boolean fiatMoney) {
        this.fiatMoney = fiatMoney;
    }

    public boolean isUsdFungible() {
        return usdFungible;
    }

    public void setUsdFungible(boolean usdFungible) {
        this.usdFungible = usdFungible;
    }

    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }

    public boolean isEtf() {
        return etf;
    }

    public void setEtf(boolean etf) {
        this.etf = etf;
    }

    public boolean isCollateral() {
        return collateral;
    }

    public void setCollateral(boolean collateral) {
        this.collateral = collateral;
    }

    public double getCollateralWeight() {
        return collateralWeight;
    }

    public void setCollateralWeight(double collateralWeight) {
        this.collateralWeight = collateralWeight;
    }

    public boolean isConvertEnabled() {
        return convertEnabled;
    }

    public void setConvertEnabled(boolean convertEnabled) {
        this.convertEnabled = convertEnabled;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean hasSpotMargin() {
        return spotMargin;
    }

    public void setSpotMargin(boolean spotMargin) {
        this.spotMargin = spotMargin;
    }

    public double getIndexPrice() {
        return indexPrice;
    }

    public void setIndexPrice(double indexPrice) {
        this.indexPrice = indexPrice;
    }

    public boolean isDepositEnabled() {
        return depositEnabled;
    }

    public void setDepositEnabled(boolean depositEnabled) {
        this.depositEnabled = depositEnabled;
    }

    public boolean isWithdrawEnabled() {
        return withdrawEnabled;
    }

    public void setWithdrawEnabled(boolean withdrawEnabled) {
        this.withdrawEnabled = withdrawEnabled;
    }

    public List<String> getNetworks() {
        return networks;
    }

    public void setNetworks(List<String> networks) {
        this.networks = networks;
    }

    public boolean hasTag() {
        return tag;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

    public String getCreditTo() {
        return creditTo;
    }

    public void setCreditTo(String creditTo) {
        this.creditTo = creditTo;
    }

    public String getBep2Asset() {
        return bep2Asset;
    }

    public void setBep2Asset(String bep2Asset) {
        this.bep2Asset = bep2Asset;
    }

    public String getErc20Contract() {
        return erc20Contract;
    }

    public void setErc20Contract(String erc20Contract) {
        this.erc20Contract = erc20Contract;
    }

    public String getTrc20Contract() {
        return trc20Contract;
    }

    public void setTrc20Contract(String trc20Contract) {
        this.trc20Contract = trc20Contract;
    }

    public String getSplMint() {
        return splMint;
    }

    public void setSplMint(String splMint) {
        this.splMint = splMint;
    }

    public boolean isNftQuoteCurrencyEligible() {
        return nftQuoteCurrencyEligible;
    }

    public void setNftQuoteCurrencyEligible(boolean nftQuoteCurrencyEligible) {
        this.nftQuoteCurrencyEligible = nftQuoteCurrencyEligible;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, FtxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("name", name)
                .append("fiatMoney", fiatMoney)
                .append("usdFungible", usdFungible)
                .append("token", token)
                .append("etf", etf)
                .append("collateral", collateral)
                .append("collateralWeight", collateralWeight)
                .append("convertEnabled", convertEnabled)
                .append("hidden", hidden)
                .append("spotMargin", spotMargin)
                .append("indexPrice", indexPrice)
                .append("depositEnabled", depositEnabled)
                .append("withdrawEnabled", withdrawEnabled)
                .append("networks", networks)
                .append("tag", tag)
                .append("creditTo", creditTo)
                .append("bep2Asset", bep2Asset)
                .append("erc20Contract", erc20Contract)
                .append("trc20Contract", trc20Contract)
                .append("splMint", splMint)
                .append("nftQuoteCurrencyEligible", nftQuoteCurrencyEligible)
                .toString();
    }
}