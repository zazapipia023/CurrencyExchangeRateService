package com.example.currencyexchangerateservice;

import com.example.currencyexchangerateservice.services.CurrencyGifService;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@WireMockTest(httpPort = 8080)
public class CurrencyGifServiceTests {

    @Autowired
    private CurrencyGifService currencyGifService;


    @Test
    public void test() {
        stubFor(get("/api/currency-gif/getCurrencyDiff")
                .willReturn(ok()));

        String result = currencyGifService.getCurrencyDifference();

        Assertions.assertNotNull(result);
    }
}
