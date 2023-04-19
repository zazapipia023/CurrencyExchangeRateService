package com.example.currencyexchangerateservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currencyRates", url = "${currencyRates.url}")
public interface CurrencyRatesClient {

    @GetMapping("/latest.json")
    ResponseEntity<String> getLatestCurrencyRates(@RequestParam("app_id") String appId);

//    TODO: Make GET request for previous day
//    https://openexchangerates.org/api/historical/2023-04-18.json?app_id=669c38ba72304ef0a9ca018ab754cb23
    @GetMapping("")
    ResponseEntity<String> getPreviousCurrencyRates(@RequestParam("app_id") String appId);
}
