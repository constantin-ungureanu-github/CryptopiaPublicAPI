package org.cryptopia.api.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Market {

    @JsonProperty("TradePairId")
    private BigInteger tradePairId;

    @JsonProperty("Label")
    private String label;

    @JsonProperty("AskPrice")
    private BigDecimal askPrice;

    @JsonProperty("BidPrice")
    private BigDecimal bidPrice;

    @JsonProperty("Low")
    private BigDecimal low;

    @JsonProperty("High")
    private BigDecimal high;

    @JsonProperty("Volume")
    private BigDecimal volume;

    @JsonProperty("LastPrice")
    private BigDecimal lastPrice;

    @JsonProperty("BuyVolume")
    private BigDecimal buyVolume;

    @JsonProperty("SellVolume")
    private BigDecimal sellVolume;

    @JsonProperty("Change")
    private BigDecimal change;

    @JsonProperty("Open")
    private BigDecimal open;

    @JsonProperty("Close")
    private BigDecimal close;

    @JsonProperty("BaseVolume")
    private BigDecimal baseVolume;

    @JsonProperty("BuyBaseVolume")
    private BigDecimal buyBaseVolume;

    @JsonProperty("SellBaseVolume")
    private BigDecimal sellBaseVolume;
}
