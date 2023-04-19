package com.example.currencyexchangerateservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSettings {

    @Value("${currency}")
    private String currency;

    @Value("${currencyRates.appId}")
    private String currencyAppId;

    @Value("${giphy.apiKey}")
    private String giphyApiKey;

    public String getCurrency() {
        return currency;
    }

    public String getCurrencyAppId() {
        return currencyAppId;
    }

    public String getGiphyApiKey() {
        return giphyApiKey;
    }
}
