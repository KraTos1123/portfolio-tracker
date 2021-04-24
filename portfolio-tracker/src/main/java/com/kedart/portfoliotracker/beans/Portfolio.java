package com.kedart.portfoliotracker.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Portfolio {

    /**
     * Name of Portfolio
     */
    private String name;

    /**
     * Absolute Profit and Loss for the Portfolio
     * Loss is shown with negative sign
     */
    private float absolutePnl;
    /**
     * Percentage Profit and Loss for the Portfolio
     * Loss is shown with negative sign
     */
    private float percentPnl;

    /**
     * Total amount of money invested in this portfolio
     */
    private float totalInvestments;

    /**
     * Current Value of Assets in this Portfolio
     */
    private float assetValue;


    /**
     * List of Assets
     */
    private List<Asset> assetList;

    public Portfolio(String name) {
        this.name = name;
        assetList = new ArrayList<>();
    }

    public Portfolio() {
        assetList = new ArrayList<>();
    }

    public float calculateAssetValue() {
        float sum = 0;
        for (Asset asset : assetList) {
            sum = sum + asset.getAssetValue();
        }
        return sum;
    }

    public float calculateTotalInvestment() {
        float sum = 0;
        for (Asset asset : assetList) {
            sum = sum + asset.getTotalInvestment();
        }
        return sum;
    }

    public float getPercentPnL() {
        return this.getAbsolutePnl() / this.getTotalInvestments() * 100;
    }

    public float getAbsolutePnl() {
        return this.getAssetValue() - this.getTotalInvestments();
    }

    public void calculateStatistics() {
        this.assetValue = this.calculateAssetValue();
        this.totalInvestments = this.calculateTotalInvestment();
    }

    public void mergeAssets(List<Asset> assets) {
        if (!assetList.isEmpty()) {
            for (Asset asset : assetList) {
                for (Asset newAsset : assets) {
                    if (asset.getAssetName().equals(newAsset.getAssetName())) {
                        asset.addTransactions(newAsset.getAssetTransactions());
                        assets.remove(newAsset);
                    }
                    if (assets.size() == 0) {
                        return;
                    }
                }
            }
        }
        this.assetList.addAll(assets);
        this.calculateStatistics();
    }
}
