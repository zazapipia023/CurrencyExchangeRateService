package com.example.currencyexchangerateservice.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "giphy", url = "${giphy.url}")
public interface GiphyClient {

}
