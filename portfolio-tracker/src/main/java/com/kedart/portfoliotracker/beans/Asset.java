package com.kedart.portfoliotracker.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
public class Asset {

    /**
     * Name of Asset
     */
    private String assetName;

    /**
     * List of Transactions made by the user for this Asset
     */
    private List<AssetTransaction> assetTransactions;

    /**
     * Type of Asset
     * e.g CRYPTO, EQUITY etc
     */
    private AssetType assetType;

    public Asset(String assetName, AssetType assetType) {
        this.assetName = assetName;
        this.assetType = assetType;
        assetTransactions = new ArrayList<>();
    }

    public Asset() {
        assetTransactions = new ArrayList<>();
    }

    public float getAssetValue() {
        float sum = 0;
        for (AssetTransaction assetTransaction : assetTransactions) {
            sum = sum + (assetTransaction.getQuantity() * assetTransaction.getCurrentPrice());
        }
        return sum;
    }

    public float getAvgBuyPrice() {
        return this.getTotalInvestment() / this.getTotalQuantity();
    }

    public float getTotalInvestment() {
        float sum = 0;
        for (AssetTransaction assetTransaction : assetTransactions) {
            sum = sum + (assetTransaction.getQuantity() * assetTransaction.getBuyPrice());
        }
        return sum;
    }

    public float getAssetPnL() {
        return (this.getAssetValue() - this.getTotalInvestment()) / this.getTotalInvestment() * 100;
    }


    public boolean addTransaction(AssetTransaction assetTransaction) {
        return assetTransactions.add(assetTransaction);
    }

    public float getTotalQuantity() {
        float sum = 0;
        for (AssetTransaction assetTransaction : assetTransactions) {
            sum = sum + assetTransaction.getQuantity();
        }
        return sum;
    }

    public boolean addTransactions(List<AssetTransaction> newAssetTransactions) {
        for (AssetTransaction transaction :
                newAssetTransactions) {
            if (transaction.getPurchaseDate() == null) {
                transaction.setPurchaseDate(Instant.now());
            }
        }
        return assetTransactions.addAll(newAssetTransactions);
    }
}
