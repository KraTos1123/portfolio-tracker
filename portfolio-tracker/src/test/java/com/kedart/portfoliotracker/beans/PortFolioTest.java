package com.kedart.portfoliotracker.beans;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PortFolioTest {
    private Portfolio portfolio;

    @BeforeEach
    void setUp() {
        Asset asset = new Asset("BTC", AssetType.CRYPTO);

        AssetTransaction transaction1 = new AssetTransaction(1, 200, 400, Instant.now(),"USD");
        AssetTransaction transaction2 = new AssetTransaction(2, 250, 400, Instant.now(),"USD");
        List<AssetTransaction> transactionList = new ArrayList<>(Arrays.asList(transaction1, transaction2));
        asset.setAssetTransactions(transactionList);

        Asset asset2 = new Asset("ETH", AssetType.CRYPTO);
        AssetTransaction transaction3 = new AssetTransaction(1, 50, 100, Instant.now(),"USD");
        List<AssetTransaction> transactionList2 = new ArrayList<>(Collections.singletonList(transaction3));
        asset2.setAssetTransactions(transactionList2);

        portfolio = new Portfolio("Vacation Funds");
        List<Asset> assets = new ArrayList<>(Arrays.asList(asset, asset2));
        portfolio.setAssetList(assets);

    }

    @Test
    void getAssetValue() {
        System.out.println("Asset Value : " + portfolio.getAssetValue());
    }

    @Test
    void getTotalInvestment() {
        System.out.println("Total Investment : " + portfolio.calculateTotalInvestment());
    }

    @Test
    void getPercentPnL() {
        System.out.println("Total PnL : " + portfolio.getPercentPnL());
    }

    @Test
    void getAbsolutePnL() {
        System.out.println("Portfolio : "+ portfolio);
        System.out.println("\nAbsolute PnL : " + portfolio.getAbsolutePnl());
    }


}
