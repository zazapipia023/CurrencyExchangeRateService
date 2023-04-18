package com.example.currencyexchangerateservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class PageController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String showMainPage() {

        return "";
    }
}
