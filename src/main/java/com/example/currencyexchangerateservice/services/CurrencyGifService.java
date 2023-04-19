package com.example.currencyexchangerateservice.services;

import com.example.currencyexchangerateservice.clients.CurrencyRatesClient;
import com.example.currencyexchangerateservice.clients.GiphyClient;
import com.example.currencyexchangerateservice.config.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyGifService {
    private final CurrencyRatesClient currencyRatesClient;
    private final GiphyClient giphyClient;

    private final AppSettings appSettings;

    private double currentValue;

    @Autowired
    public CurrencyGifService(CurrencyRatesClient currencyRatesClient, GiphyClient giphyClient, AppSettings appSettings) {
        this.currencyRatesClient = currencyRatesClient;
        this.giphyClient = giphyClient;
        this.appSettings = appSettings;
    }

    public String getLatestCurrencyRates() {
        ResponseEntity<String> responseEntity = currencyRatesClient.getLatestCurrencyRates(appSettings.getCurrencyAppId());
        return responseEntity.getBody();
    }

    public String getRichGif() {
        ResponseEntity<String> responseEntity = giphyClient.getRichGif(appSettings.getGiphyApiKey());
        return responseEntity.getBody();
    }
}
