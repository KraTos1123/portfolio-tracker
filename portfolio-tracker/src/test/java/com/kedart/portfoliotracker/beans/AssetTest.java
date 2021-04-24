package com.kedart.portfoliotracker.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssetTest {

    private Asset asset;

    @BeforeEach
    void setUp() {
        asset = new Asset("BTC", AssetType.CRYPTO);
        List<AssetTransaction> transactionList = new ArrayList<>();
        AssetTransaction transaction1 = new AssetTransaction(1, 200, 400, Instant.now(),"USD");
        AssetTransaction transaction2 = new AssetTransaction(2, 250, 400, Instant.now(),"USD");
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        asset.setAssetTransactions(transactionList);
    }

    @Test
    void getAssetValue() {
        System.out.println("Asset Value : " + asset.getAssetValue());
    }

    @Test
    void getAvgBuyPrice() {
        System.out.println("Average Buy Price : " + asset.getAvgBuyPrice());
    }

    @Test
    void getTotalInvestment() {
        System.out.println("Total Investment : " + asset.getTotalInvestment());
    }

    @Test
    void getAssetPnL() {
        System.out.println("Total PnL : " + asset.getAssetPnL());
    }


}