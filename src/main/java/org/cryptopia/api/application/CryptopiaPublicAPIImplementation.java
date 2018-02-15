package org.cryptopia.api.application;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.cryptopia.api.CryptopiaPublicAPI;
import org.cryptopia.api.domain.CryptopiaResponse;
import org.cryptopia.api.domain.Currency;
import org.cryptopia.api.domain.Market;
import org.cryptopia.api.domain.MarketHistory;
import org.cryptopia.api.domain.MarketOrderGroup;
import org.cryptopia.api.domain.MarketOrders;
import org.cryptopia.api.domain.TradePair;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CryptopiaPublicAPIImplementation implements CryptopiaPublicAPI {
    private final Client client = ClientBuilder.newClient();
    private final WebTarget target = client.target(REST_URI);

    @Override
    public List<Currency> getCurrencies() {
        final String endpoint = "GetCurrencies";
        log.info("{}{}", REST_URI, endpoint);

        final CryptopiaResponse<List<Currency>> response = target.path(endpoint).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<CryptopiaResponse<List<Currency>>>() {});

        if (Boolean.parseBoolean(response.getSuccess())) {
            return response.getData();
        }

        return Collections.emptyList();
    }

    @Override
    public List<TradePair> getTradePairs() {
        final String endpoint = "GetTradePairs";
        log.info("{}{}", REST_URI, endpoint);

        final CryptopiaResponse<List<TradePair>> response = target.path(endpoint).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<CryptopiaResponse<List<TradePair>>>() {});

        if (Boolean.parseBoolean(response.getSuccess())) {
            return response.getData();
        }

        return Collections.emptyList();
    }

    @Override
    public List<Market> getMarkets(final Optional<String> baseMarket, final Optional<Integer> hours) {
        final String endpoint = "GetMarkets" + (baseMarket.isPresent() ? "/" + baseMarket.get() : "") + (hours.isPresent() ? "/" + hours.get() : "");
        log.info("{}{}", REST_URI, endpoint);

        final CryptopiaResponse<List<Market>> response = target.path(endpoint).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<CryptopiaResponse<List<Market>>>() {});

        if (Boolean.parseBoolean(response.getSuccess())) {
            return response.getData();
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Market> getMarket(@NonNull final String marketName, final Optional<Integer> hours) {
        final String endpoint = "GetMarket/" + marketName + (hours.isPresent() ? "/" + hours.get() : "");
        log.info("{}{}", REST_URI, endpoint);

        final CryptopiaResponse<Market> response = target.path(endpoint).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<CryptopiaResponse<Market>>() {});

        if (Boolean.parseBoolean(response.getSuccess())) {
            return Optional.ofNullable(response.getData());
        }

        return Optional.empty();
    }

    @Override
    public List<MarketHistory> getMarketHistory(final String marketName, final Optional<Integer> hours) {
        final String endpoint = "GetMarketHistory/" + marketName + (hours.isPresent() ? "/" + hours.get() : "");
        log.info("{}{}", REST_URI, endpoint);

        final CryptopiaResponse<List<MarketHistory>> response = target.path(endpoint).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<CryptopiaResponse<List<MarketHistory>>>() {});

        if (Boolean.parseBoolean(response.getSuccess())) {
            return response.getData();
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<MarketOrders> getMarketOrders(@NonNull final String marketName, final Optional<Integer> orderCount) {
        final String endpoint = "GetMarketOrders/" + marketName + (orderCount.isPresent() ? "/" + orderCount.get() : "");
        log.info("{}{}", REST_URI, endpoint);

        final CryptopiaResponse<MarketOrders> response = target.path(endpoint).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<CryptopiaResponse<MarketOrders>>() {});

        if (Boolean.parseBoolean(response.getSuccess())) {
            return Optional.ofNullable(response.getData());
        }

        return Optional.empty();
    }

    @Override
    public List<MarketOrderGroup> getMarketOrderGroups(final String marketName, final Optional<Integer> orderCount) {
        final String endpoint = "GetMarketOrderGroups/" + marketName + (orderCount.isPresent() ? "/" + orderCount.get() : "");
        log.info("{}{}", REST_URI, endpoint);

        final CryptopiaResponse<List<MarketOrderGroup>> response = target.path(endpoint).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<CryptopiaResponse<List<MarketOrderGroup>>>() {});

        if (Boolean.parseBoolean(response.getSuccess())) {
            return response.getData();
        }

        return Collections.emptyList();
    }
}
