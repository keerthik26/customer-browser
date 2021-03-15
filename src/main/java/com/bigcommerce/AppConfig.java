package com.bigcommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    //TODO: Read these from Properties File. Does storeBaseUrl belong to this Class?
    private static final String storeBaseUrl = "https://dominica-ernsers-store.mybigcommerce.com/api/v2";
    private static final String username = "test";
    private static final String password = "2525df56477f58e5868c240ee5228b0b5d4367c4";

    @Bean
    public WebClient webClient() {
        WebClient webClient = WebClient.builder()
                .filter(ExchangeFilterFunctions.basicAuthentication(username, password))
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(storeBaseUrl)
                .build();
        return webClient;
    }
}
