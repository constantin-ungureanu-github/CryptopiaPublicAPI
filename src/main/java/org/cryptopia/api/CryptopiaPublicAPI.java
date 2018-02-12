package org.cryptopia.api;

import java.util.List;
import java.util.Optional;

import org.cryptopia.api.domain.Currency;
import org.cryptopia.api.domain.Market;
import org.cryptopia.api.domain.MarketHistory;
import org.cryptopia.api.domain.MarketOrderGroup;
import org.cryptopia.api.domain.MarketOrders;
import org.cryptopia.api.domain.TradePair;

import lombok.NonNull;

public interface CryptopiaPublicAPI {
    List<Currency> getCurrencies();

    List<TradePair> getTradePairs();

    List<Market> getMarkets(Optional<String> baseMarket, Optional<Integer> hours);

    Optional<Market> getMarket(@NonNull String marketName, Optional<Integer> hours);

    List<MarketHistory> getMarketHistory(@NonNull String marketName, Optional<Integer> hours);

    Optional<MarketOrders> getMarketOrders(@NonNull String marketName, Optional<Integer> orderCount);

    List<MarketOrderGroup> getMarketOrderGroups(@NonNull String marketName, Optional<Integer> orderCount);
}
