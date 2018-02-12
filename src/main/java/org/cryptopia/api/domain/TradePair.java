package org.cryptopia.api.domain;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TradePair {

    @JsonProperty("Id")
    private BigInteger id;

    @JsonProperty("Label")
    private String label;

    @JsonProperty("Currency")
    private String currency;

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("BaseCurrency")
    private String baseCurrency;

    @JsonProperty("BaseSymbol")
    private String baseSymbol;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("StatusMessage")
    private String statusMessage;

    @JsonProperty("TradeFee")
    private String tradeFee;

    @JsonProperty("MinimumTrade")
    private String minimumTrade;

    @JsonProperty("MaximumTrade")
    private String maximumTrade;

    @JsonProperty("MinimumBaseTrade")
    private String minimumBaseTrade;

    @JsonProperty("MaximumBaseTrade")
    private String maximumBaseTrade;

    @JsonProperty("MinimumPrice")
    private String minimumPrice;

    @JsonProperty("MaximumPrice")
    private String maximumPrice;
}
