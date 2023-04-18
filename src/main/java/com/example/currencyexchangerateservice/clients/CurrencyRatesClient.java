package com.example.currencyexchangerateservice.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "currencyRates", url = "${currencyRates.url}")
public interface CurrencyRatesClient {

}
