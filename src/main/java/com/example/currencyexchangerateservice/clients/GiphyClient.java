package com.example.currencyexchangerateservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy", url = "${giphy.url}")
public interface GiphyClient {

    @GetMapping("?q={gifType}")
    ResponseEntity<String> getRichGif(@RequestParam("api_key") String apiKey, @PathVariable String gifType);
}
