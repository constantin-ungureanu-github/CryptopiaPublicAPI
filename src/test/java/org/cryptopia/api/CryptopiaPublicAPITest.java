package org.cryptopia.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.cryptopia.api.application.CryptopiaPublicAPIImplementation;
import org.cryptopia.api.domain.Currency;
import org.cryptopia.api.domain.Market;
import org.cryptopia.api.domain.MarketHistory;
import org.cryptopia.api.domain.MarketOrderGroup;
import org.cryptopia.api.domain.MarketOrders;
import org.cryptopia.api.domain.Order;
import org.cryptopia.api.domain.TradePair;
import org.junit.Test;

public class CryptopiaPublicAPITest {
    private static final String BASE_MARKET = "USDT";
    private static final String MARKET = "BTC_USDT";
    private static final int HOURS = 12;
    private static final int ORDER_COUNT = 1;

    private final CryptopiaPublicAPI cryptopia = new CryptopiaPublicAPIImplementation();

    @Test
    public void testGetCurrencies() {
        final List<Currency> currencies = cryptopia.getCurrencies();

        assertFalse(currencies.isEmpty());

        testCurrency(currencies.get(0));
    }

    private void testCurrency(final Currency currency) {
        assertNotNull(currency.getId());
        assertNotNull(currency.getName());
        assertNotNull(currency.getSymbol());
        assertNotNull(currency.getAlgorithm());
        assertNotNull(currency.getWithdrawFee());
        assertNotNull(currency.getMinWithdraw());
        assertNotNull(currency.getMinBaseTrade());
        assertNotNull(currency.getIsTipEnabled());
        assertNotNull(currency.getMinTip());
        assertNotNull(currency.getDepositConfirmations());
        assertNotNull(currency.getStatus());
        assertNotNull(currency.getListingStatus());
    }

    @Test
    public void testGetTradePairs() {
        final List<TradePair> tradePairs = cryptopia.getTradePairs();

        assertFalse(tradePairs.isEmpty());

        testTradePair(tradePairs.get(0));
    }

    private void testTradePair(final TradePair tradePair) {
        assertNotNull(tradePair.getId());
        assertNotNull(tradePair.getLabel());
        assertNotNull(tradePair.getCurrency());
        assertNotNull(tradePair.getSymbol());
        assertNotNull(tradePair.getBaseCurrency());
        assertNotNull(tradePair.getBaseSymbol());
        assertNotNull(tradePair.getStatus());
        assertNotNull(tradePair.getTradeFee());
        assertNotNull(tradePair.getMinimumTrade());
        assertNotNull(tradePair.getMaximumTrade());
        assertNotNull(tradePair.getMinimumBaseTrade());
        assertNotNull(tradePair.getMaximumBaseTrade());
        assertNotNull(tradePair.getMinimumPrice());
        assertNotNull(tradePair.getMaximumPrice());
    }

    @Test
    public void testGetMarkets() {
        final List<Market> markets = cryptopia.getMarkets(Optional.of(BASE_MARKET), Optional.of(HOURS));

        assertFalse(markets.isEmpty());

        testMarket(markets.get(0));
    }

    @Test
    public void testGetMarketsEmptyBaseMarket() {
        final List<Market> markets = cryptopia.getMarkets(Optional.empty(), Optional.of(HOURS));

        assertFalse(markets.isEmpty());

        testMarket(markets.get(0));
    }

    @Test
    public void testGetMarketsEmptyHours() {
        final List<Market> markets = cryptopia.getMarkets(Optional.of(BASE_MARKET), Optional.empty());

        assertFalse(markets.isEmpty());

        testMarket(markets.get(0));
    }

    @Test
    public void testGetMarketsEmptyBaseMarketEmptyHours() {
        final List<Market> markets = cryptopia.getMarkets(Optional.empty(), Optional.empty());

        assertFalse(markets.isEmpty());

        testMarket(markets.get(0));
    }

    @Test
    public void testGetMarket() {
        final Optional<Market> market = cryptopia.getMarket(MARKET, Optional.of(HOURS));

        assertTrue(market.isPresent());

        testMarket(market.get());
    }

    @Test
    public void testGetMarketEmptyHours() {
        final Optional<Market> market = this.cryptopia.getMarket(MARKET, Optional.empty());

        assertTrue(market.isPresent());

        testMarket(market.get());
    }

    private void testMarket(final Market market) {
        assertNotNull(market.getTradePairId());
        assertNotNull(market.getLabel());
        assertNotNull(market.getAskPrice());
        assertNotNull(market.getBidPrice());
        assertNotNull(market.getLow());
        assertNotNull(market.getHigh());
        assertNotNull(market.getVolume());
        assertNotNull(market.getLastPrice());
        assertNotNull(market.getBuyVolume());
        assertNotNull(market.getSellVolume());
        assertNotNull(market.getChange());
        assertNotNull(market.getOpen());
        assertNotNull(market.getClose());
        assertNotNull(market.getBaseVolume());
        assertNotNull(market.getBuyBaseVolume());
        assertNotNull(market.getSellBaseVolume());
    }

    @Test
    public void testGetMarketHistory() {
        final List<MarketHistory> marketHistories = cryptopia.getMarketHistory(MARKET, Optional.of(HOURS));
        assertFalse(marketHistories.isEmpty());

        final MarketHistory marketHistory = marketHistories.get(0);

        assertMarketHistory(marketHistory);
    }

    @Test
    public void testGetMarketHistoryEmptyHours() {
        final List<MarketHistory> marketHistories = cryptopia.getMarketHistory(MARKET, Optional.empty());

        assertFalse(marketHistories.isEmpty());

        assertMarketHistory(marketHistories.get(0));
    }

    private void assertMarketHistory(final MarketHistory marketHistory) {
        assertNotNull(marketHistory.getTradePairId());
        assertNotNull(marketHistory.getLabel());
        assertNotNull(marketHistory.getType());
        assertNotNull(marketHistory.getPrice());
        assertNotNull(marketHistory.getAmount());
        assertNotNull(marketHistory.getTotal());
        assertNotNull(marketHistory.getTimestamp());
    }

    @Test
    public void testGetMarketOrders() {
        final Optional<MarketOrders> marketOrders = cryptopia.getMarketOrders(MARKET, Optional.of(ORDER_COUNT));

        assertTrue(marketOrders.isPresent());

        testMarketOrders(marketOrders.get());
    }

    @Test
    public void testGetMarketOrdersEmptyOrderCount() {
        final Optional<MarketOrders> marketOrders = cryptopia.getMarketOrders(MARKET, Optional.empty());

        assertTrue(marketOrders.isPresent());

        testMarketOrders(marketOrders.get());
    }

    @Test
    public void testGetMarketOrderGroups() {
        final List<MarketOrderGroup> marketOrderGroups = cryptopia.getMarketOrderGroups(MARKET, Optional.empty());

        assertFalse(marketOrderGroups.isEmpty());

        testMarketOrderGroup(marketOrderGroups);
    }

    @Test
    public void testGetMarketOrderGroups1() {
        final List<MarketOrderGroup> marketOrderGroups = cryptopia.getMarketOrderGroups(MARKET, Optional.of(ORDER_COUNT));

        assertFalse(marketOrderGroups.isEmpty());

        testMarketOrderGroup(marketOrderGroups);
    }

    private void testMarketOrderGroup(final List<MarketOrderGroup> marketOrderGroups) {
        final MarketOrderGroup marketOrderGroup = marketOrderGroups.get(0);

        assertNotNull(marketOrderGroup.getTradePairId());
        assertNotNull(marketOrderGroup.getMarket());

        assertNotNull(marketOrderGroup.getBuy());
        assertNotNull(marketOrderGroup.getSell());

        testMarketOrder(marketOrderGroup.getBuy());
        testMarketOrder(marketOrderGroup.getSell());
    }

    private void testMarketOrders(final MarketOrders marketOrders) {
        assertNotNull(marketOrders.getBuy());
        assertNotNull(marketOrders.getSell());

        testMarketOrder(marketOrders.getBuy());
        testMarketOrder(marketOrders.getSell());
    }

    private void testMarketOrder(final List<Order> orderList) {
        assertFalse(orderList.isEmpty());
        testOrder(orderList.get(0));
    }

    private void testOrder(final Order order) {
        assertNotNull(order.getTradePairId());
        assertNotNull(order.getLabel());
        assertNotNull(order.getPrice());
        assertNotNull(order.getVolume());
        assertNotNull(order.getTotal());
    }
}
