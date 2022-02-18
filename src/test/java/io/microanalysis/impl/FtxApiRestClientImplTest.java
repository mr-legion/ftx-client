package io.microanalysis.impl;

import io.microanalysis.FtxApiClientFactory;
import io.microanalysis.FtxApiRestClient;
import io.microanalysis.domain.Response;
import io.microanalysis.domain.futures.FundingRate;
import io.microanalysis.domain.general.Asset;
import io.microanalysis.domain.market.MarketTicker;
import io.microanalysis.domain.market.OrderBook;
import io.microanalysis.domain.market.Trade;
import io.microanalysis.domain.trading.NewOrder;
import io.microanalysis.domain.trading.OpenOrder;
import io.microanalysis.security.ApiCredentials;
import io.microanalysis.security.ApiKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static io.microanalysis.domain.OrderSide.BUY;
import static io.microanalysis.domain.OrderType.LIMIT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FtxApiRestClientImplTest {

    private FtxApiRestClient ftxApiRestClient;

    @BeforeEach
    public void setUp() {

        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        String subAccountName = System.getenv("SUB_ACCOUNT_NAME");

        ApiCredentials apiCredentials = new ApiCredentials(new ApiKey(apiKey), secret, subAccountName);
        this.ftxApiRestClient = FtxApiClientFactory.newInstance(apiCredentials).newRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() {
        Response<List<Asset>> response = ftxApiRestClient.getAssets();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Response<List<MarketTicker>> response = ftxApiRestClient.getMarketTickers();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getTradesForBTCUSD_ShouldReturnTrades() {
        String market = "BTC/USD";
        long startTime = Instant.now().minus(24, ChronoUnit.HOURS).getEpochSecond();
        long endTime = Instant.now().getEpochSecond();
        Response<List<Trade>> response = ftxApiRestClient.getTrades(market, startTime, endTime);
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getOrderBookForBTCUSD_ShouldReturnOrderBook() {
        String market = "BTC/USD";
        int limit = 20;
        Response<OrderBook> response = ftxApiRestClient.getOrderBook(market, limit);
        assertNotNull(response);
        assertNotNull(response.getData());
        assertThat(response.getData().getAsks(), is(not(empty())));
        assertThat(response.getData().getBids(), is(not(empty())));
    }

    @Test
    public void getFundingRates_ShouldReturnFundingRates() {
        String future = "BTC-PERP";
        long startTime = Instant.now().minus(24, ChronoUnit.HOURS).getEpochSecond();
        long endTime = Instant.now().getEpochSecond();
        Response<List<FundingRate>> response = ftxApiRestClient.getFundingRates(future, startTime, endTime);
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void tradingTest_ShouldPlaceAndGetAndCancelOrder() {

        String market = "BTC/USD";
        double price = 3000;
        double quantity = 0.0003;

        NewOrder order = new NewOrder(market, price, quantity, BUY, LIMIT);

        long orderId = ftxApiRestClient.placeOrder(order).getData().getId();
        OpenOrder openOrder = ftxApiRestClient.getOpenOrders(market).getData().get(0);
        assertEquals(orderId, openOrder.getId());

        ftxApiRestClient.cancelOrder(orderId);

        List<OpenOrder> openOrders = ftxApiRestClient.getOpenOrders(market).getData();
        assertThat(openOrders, is(empty()));
    }
}