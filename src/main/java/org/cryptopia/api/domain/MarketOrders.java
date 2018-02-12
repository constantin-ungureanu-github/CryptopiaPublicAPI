package org.cryptopia.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MarketOrders {

    @JsonProperty("Buy")
    List<Order> buy;

    @JsonProperty("Sell")
    List<Order> sell;
}
