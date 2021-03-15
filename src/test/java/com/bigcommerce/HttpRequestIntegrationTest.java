package com.bigcommerce;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestIntegrationTest {

    @LocalServerPort
    private int port;

    private URL baseUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() throws MalformedURLException {
        baseUrl = new URL("http://localhost:" + port + "/customers");
    }

    @Test
    public void customerShouldReturnCustomersHtmlPage() throws URISyntaxException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(baseUrl.toString(), String.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody())
                .contains("<title>Customer Browser Home Page</title>");

    }
}
