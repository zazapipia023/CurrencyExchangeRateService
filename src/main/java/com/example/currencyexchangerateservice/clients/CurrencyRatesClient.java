package com.example.currencyexchangerateservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currencyRates", url = "${currencyRates.url}")
public interface CurrencyRatesClient {

    @GetMapping("/latest.json")
    ResponseEntity<String> getLatestCurrencyRates(@RequestParam("app_id") String appId);

    @GetMapping("/historical/{date}.json")
    ResponseEntity<String> getPreviousCurrencyRates(@RequestParam("app_id") String appId, @PathVariable String date);
}
