package org.cryptopia.api.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Currency {
    @JsonProperty("Id")
    private BigInteger id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("Algorithm")
    private String algorithm;

    @JsonProperty("WithdrawFee")
    private BigDecimal withdrawFee;

    @JsonProperty("MinWithdraw")
    private BigDecimal minWithdraw;

    @JsonProperty("MaxWithdraw")
    private BigDecimal maxWithdraw;

    @JsonProperty("MinBaseTrade")
    private BigDecimal minBaseTrade;

    @JsonProperty("IsTipEnabled")
    private Boolean isTipEnabled;

    @JsonProperty("MinTip")
    private BigDecimal minTip;

    @JsonProperty("DepositConfirmations")
    private BigInteger depositConfirmations;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("StatusMessage")
    private String statusMessage;

    @JsonProperty("ListingStatus")
    private String listingStatus;
}
