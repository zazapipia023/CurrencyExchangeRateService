package com.example.currencyexchangerateservice;

import feign.Feign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyExchangeRateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeRateServiceApplication.class, args);
    }
}
