package com.kedart.portfoliotracker.controller;

import com.kedart.portfoliotracker.beans.Asset;
import com.kedart.portfoliotracker.beans.Portfolio;
import com.kedart.portfoliotracker.services.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController("portfolios")
@RequestMapping("portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }


    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Portfolio getPortfolio(@PathVariable String name) {
        Optional<Portfolio> portfolio = portfolioService.getPortfolio(name);
        if (portfolio.isPresent()) {
            return portfolio.get();
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No portfolio with this name found !!");
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Portfolio addPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio addedPortfolio;
        try {
            addedPortfolio = portfolioService.addPortfolio(portfolio);
        } catch (Exception exception) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "No portfolio with this name found !!");
        }
        return addedPortfolio;
    }

    @GetMapping("/{name}/assets")
    @ResponseStatus(HttpStatus.OK)
    public List<Asset> getAssets(@PathVariable String name) {
        return this.getPortfolio(name).getAssetList();
    }


    @PutMapping("/{name}/assets/add")
    @ResponseStatus(HttpStatus.OK)
    public Portfolio addAssets(@PathVariable String name, @RequestBody List<Asset> assets) {
        Portfolio portfolio = this.getPortfolio(name);
        portfolio.mergeAssets(assets);
        return portfolio;
    }

}
