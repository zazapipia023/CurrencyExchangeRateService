package com.example.currencyexchangerateservice.services;

import com.example.currencyexchangerateservice.clients.CurrencyRatesClient;
import com.example.currencyexchangerateservice.clients.GiphyClient;
import com.example.currencyexchangerateservice.config.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        // TODO: Make difference using JSON
        int index = responseEntityCurrent.getBody().indexOf(appSettings.getCurrency());
        Double currentRate = Double.parseDouble(responseEntityCurrent.getBody().substring(index + 6, index + 15));
        index = responseEntityPrevious.getBody().indexOf(appSettings.getCurrency());
        Double previousRate = Double.parseDouble(responseEntityPrevious.getBody().substring(index + 6, index + 15));



        return currentRate - previousRate > 0 ? "Сегодня > вчера" : "Вчера > сегодня";
    }

    public ResponseEntity<String> getPreviousCurrencyRates() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String formattedDate = yesterday.format(DATE_FORMAT);

        ResponseEntity<String> responseEntity = currencyRatesClient.getPreviousCurrencyRates(appSettings.getCurrencyAppId(), formattedDate);
        return responseEntity;
    }

    // TODO: Make method, which gives back to user GIF image, in relation to currency difference
    public String getRichGif() {
        ResponseEntity<String> responseEntity = giphyClient.getRichGif(appSettings.getGiphyApiKey());
        return responseEntity.getBody();
    }


}
