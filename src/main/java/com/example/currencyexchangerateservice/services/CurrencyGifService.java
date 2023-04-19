package com.example.currencyexchangerateservice.services;

import com.example.currencyexchangerateservice.clients.CurrencyRatesClient;
import com.example.currencyexchangerateservice.clients.GiphyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyGifService {
    private final CurrencyRatesClient currencyRatesClient;
    private final GiphyClient giphyClient;

    @Autowired
    public CurrencyGifService(CurrencyRatesClient currencyRatesClient, GiphyClient giphyClient) {
        this.currencyRatesClient = currencyRatesClient;
        this.giphyClient = giphyClient;
    }

    public String getLatestCurrencyRates(String appId) {
        ResponseEntity<String> responseEntity = currencyRatesClient.getLatestCurrencyRates(appId);
        return responseEntity.getBody();
    }

    public String getRichGif(String apiKey) {
        ResponseEntity<String> responseEntity = giphyClient.getRichGif(apiKey);
        return responseEntity.getBody();
    }
}
