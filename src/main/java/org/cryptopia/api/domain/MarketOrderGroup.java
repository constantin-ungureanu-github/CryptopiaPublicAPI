package org.cryptopia.api.domain;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MarketOrderGroup {
    @JsonProperty("TradePairId")
    private BigInteger tradePairId;

    @JsonProperty("Market")
    private String market;

    @JsonProperty("Buy")
    List<Order> buy;

    @JsonProperty("Sell")
    List<Order> sell;
}
