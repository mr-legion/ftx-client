package com.ftx.impl;

import com.ftx.FtxApiAsyncRestClient;
import com.ftx.FtxApiClientFactory;
import com.ftx.domain.Response;
import com.ftx.domain.futures.FundingRate;
import com.ftx.domain.general.Asset;
import com.ftx.domain.market.MarketTicker;
import com.ftx.domain.market.OrderBook;
import com.ftx.domain.market.Trade;
import com.ftx.domain.trading.NewOrder;
import com.ftx.domain.trading.OpenOrder;
import com.ftx.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.ftx.domain.OrderSide.BUY;
import static com.ftx.domain.OrderType.LIMIT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FtxApiAsyncRestClientImplTest {

    private FtxApiAsyncRestClient ftxApiAsyncRestClient;

    @BeforeEach
    public void setUp() {

        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        String subAccountName = System.getenv("SUB_ACCOUNT_NAME");

        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret, subAccountName);
        this.ftxApiAsyncRestClient = FtxApiClientFactory.newInstance(apiCredentials).newAsyncRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Response<List<Asset>> response = ftxApiAsyncRestClient.getAssets().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        Response<List<MarketTicker>> response = ftxApiAsyncRestClient.getMarketTickers().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getTradesForBTCUSD_ShouldReturnTrades() throws ExecutionException, InterruptedException {
        String market = "BTC/USD";
        long startTime = Instant.now().minus(24, ChronoUnit.HOURS).getEpochSecond();
        long endTime = Instant.now().getEpochSecond();
        Response<List<Trade>> response = ftxApiAsyncRestClient.getTrades(market, startTime, endTime).get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getOrderBookForBTCUSD_ShouldReturnOrderBook() throws ExecutionException, InterruptedException {
        String market = "BTC/USD";
        int limit = 20;
        Response<OrderBook> response = ftxApiAsyncRestClient.getOrderBook(market, limit).get();
        assertNotNull(response);
        assertNotNull(response.getData());
        assertThat(response.getData().getAsks(), is(not(empty())));
        assertThat(response.getData().getBids(), is(not(empty())));
    }

    @Test
    public void getFundingRates_ShouldReturnFundingRates() throws ExecutionException, InterruptedException {
        String future = "BTC-PERP";
        long startTime = Instant.now().minus(24, ChronoUnit.HOURS).getEpochSecond();
        long endTime = Instant.now().getEpochSecond();
        Response<List<FundingRate>> response = ftxApiAsyncRestClient.getFundingRates(future, startTime, endTime).get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void tradingTest_ShouldPlaceAndGetAndCancelOrder() throws ExecutionException, InterruptedException {

        String market = "BTC/USD";
        double price = 3000;
        double quantity = 0.0003;

        NewOrder order = new NewOrder(market, price, quantity, BUY, LIMIT);

        long orderId = ftxApiAsyncRestClient.placeOrder(order).get().getData().getId();
        OpenOrder openOrder = ftxApiAsyncRestClient.getOpenOrders(market).get().getData().get(0);
        assertEquals(orderId, openOrder.getId());

        ftxApiAsyncRestClient.cancelOrder(orderId).get();

        List<OpenOrder> openOrders = ftxApiAsyncRestClient.getOpenOrders(market).get().getData();
        assertThat(openOrders, is(empty()));
    }
}