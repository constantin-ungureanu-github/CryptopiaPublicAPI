package org.cryptopia.api.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MarketHistory {

    @JsonProperty("TradePairId")
    private BigInteger tradePairId;

    @JsonProperty("Label")
    private String label;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Total")
    private BigDecimal total;

    @JsonProperty("Timestamp")
    private Long timestamp;
}
