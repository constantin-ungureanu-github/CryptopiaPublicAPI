package org.cryptopia.api.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Order {
    @JsonProperty("TradePairId")
    private BigInteger tradePairId;

    @JsonProperty("Label")
    private String label;

    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("Volume")
    private BigDecimal volume;

    @JsonProperty("Total")
    private BigDecimal total;
}
