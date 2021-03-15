package com.bigcommerce;

import com.bigcommerce.controller.CustomerController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(customerController).isNotNull();
    }
}