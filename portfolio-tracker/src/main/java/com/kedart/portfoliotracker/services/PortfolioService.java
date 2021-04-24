package com.kedart.portfoliotracker.services;

import com.kedart.portfoliotracker.beans.Portfolio;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PortfolioService {

    private final List<Portfolio> portfolios;

    public PortfolioService() {
        portfolios = new ArrayList<>();
    }

    public Portfolio addPortfolio(Portfolio portfolio) {
        portfolios.add(portfolio);
        portfolio.calculateStatistics();
        return portfolio;
    }

    public Optional<Portfolio> getPortfolio(String name) {
        for (Portfolio portfolio : portfolios) {
            if (portfolio.getName().equals(name)) {
                portfolio.calculateStatistics();
                return Optional.of(portfolio);
            }
        }
        return Optional.empty();
    }
}
