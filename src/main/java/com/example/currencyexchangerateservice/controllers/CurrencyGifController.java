package com.example.currencyexchangerateservice.controllers;

import com.example.currencyexchangerateservice.services.CurrencyGifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency-gif")
public class CurrencyGifController {
    private final CurrencyGifService currencyGifService;

    @Autowired
    public CurrencyGifController(CurrencyGifService currencyGifService) {
        this.currencyGifService = currencyGifService;
    }

    @GetMapping("/getCurrencyDiff")
    public String getDiffGif() {
        return currencyGifService.getLatestCurrencyRates("669c38ba72304ef0a9ca018ab754cb23");
    }

    @GetMapping("/getRichGif")
    public String getRichGif() {
        return currencyGifService.getRichGif("V0WZW5vNmXN9cmFHl9bbEd2RrQWwZhAt");
    }
}
