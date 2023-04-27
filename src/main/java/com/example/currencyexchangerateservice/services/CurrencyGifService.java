package com.example.currencyexchangerateservice.services;

import com.example.currencyexchangerateservice.clients.CurrencyRatesClient;
import com.example.currencyexchangerateservice.clients.GiphyClient;
import com.example.currencyexchangerateservice.config.AppSettings;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class CurrencyGifService {
    private final CurrencyRatesClient currencyRatesClient;
    private final GiphyClient giphyClient;

    private final AppSettings appSettings;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    public CurrencyGifService(CurrencyRatesClient currencyRatesClient, GiphyClient giphyClient, AppSettings appSettings) {
        this.currencyRatesClient = currencyRatesClient;
        this.giphyClient = giphyClient;
        this.appSettings = appSettings;
    }

    public String getCurrencyDifference() {
        ResponseEntity<String> responseEntityCurrent = currencyRatesClient.getLatestCurrencyRates(appSettings.getCurrencyAppId());
        ResponseEntity<String> responseEntityPrevious = getPreviousCurrencyRates();

        JSONObject currentRates = new JSONObject(responseEntityCurrent.getBody()).getJSONObject("rates");
        Double currentRate = currentRates.getDouble(appSettings.getCurrency());

        JSONObject previousRates = new JSONObject(responseEntityPrevious.getBody()).getJSONObject("rates");
        Double previousRate = previousRates.getDouble(appSettings.getCurrency());

        return currentRate - previousRate >= 0 ? getGif("rich") : getGif("broke");
    }

    public ResponseEntity<String> getPreviousCurrencyRates() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String formattedDate = yesterday.format(DATE_FORMAT);

        ResponseEntity<String> responseEntity = currencyRatesClient.getPreviousCurrencyRates(appSettings.getCurrencyAppId(), formattedDate);
        return responseEntity;
    }

    public String getGif(String gifType) {
        ResponseEntity<String> responseEntity = giphyClient.getRichGif(appSettings.getGiphyApiKey(), gifType);
        JSONObject jsonObject = new JSONObject(responseEntity.getBody());
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        String url = jsonArray.getJSONObject((int) (Math.random() * 50))
                .getJSONObject("images").getJSONObject("original").getString("url");

        return url;
    }

}
