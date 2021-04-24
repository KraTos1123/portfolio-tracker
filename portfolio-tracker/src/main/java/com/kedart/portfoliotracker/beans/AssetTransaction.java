package com.kedart.portfoliotracker.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AssetTransaction {

    /**
     * Total quantity purchased in this transaction
     */
    private float quantity;

    /**
     * This is the total price which a user paid for the quantity
     */
    private float buyPrice;

    /**
     * Current Price of Asset
     */
    private float currentPrice;

    /**
     * Date when Asset transaction was made
     */
    private Instant purchaseDate;

    /**
     * Currency used in purchase of Asset
     */
    private String currency;

    public void setPurchaseDate(Instant purchaseDate) {
        if(purchaseDate == null){
            purchaseDate = Instant.now();
        }
        this.purchaseDate = purchaseDate;
    }
}
