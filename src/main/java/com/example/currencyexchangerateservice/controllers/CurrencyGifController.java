package com.example.currencyexchangerateservice.controllers;

import com.example.currencyexchangerateservice.services.CurrencyGifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/currency-gif")
public class CurrencyGifController {
    private final CurrencyGifService currencyGifService;

    @Autowired
    public CurrencyGifController(CurrencyGifService currencyGifService) {
        this.currencyGifService = currencyGifService;
    }

    @GetMapping("/getCurrencyDiff")
    public String getDiffGif(Model model) {
        model.addAttribute("pathToGif", currencyGifService.getCurrencyDifference());
        return "index";
    }

}
