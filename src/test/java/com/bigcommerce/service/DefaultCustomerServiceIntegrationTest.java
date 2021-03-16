package com.bigcommerce.service;

import com.bigcommerce.dto.CustomerDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DefaultCustomerServiceIntegrationTest {

    @Autowired
    private DefaultCustomerService customerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getCustomersWithTheirTotalNoOfOrders() {
        List<CustomerDTO> customersWithTotalNoOfOrders = customerService.getCustomersWithTheirTotalNoOfOrders(0);
        Assertions.assertThat(customersWithTotalNoOfOrders).matches(customerDTOS -> customerDTOS.size() > 0);
    }

    @Test
    void getCustomersWithTheirTotalNoOfOrdersForAPage() {
        List<CustomerDTO> customersWithTotalNoOfOrders = customerService.getCustomersWithTheirTotalNoOfOrders(1);
        Assertions.assertThat(customersWithTotalNoOfOrders).matches(customerDTOS -> customerDTOS.size() == 25);
    }

    @Test
    void getCustomerOrderHistoryShouldReturnCustomerDTO() {
        String customerId = "485";

        CustomerDTO customerOrderHistory = customerService.getCustomerOrderHistory(customerId);

        Assertions.assertThat(customerOrderHistory).hasAllNullFieldsOrPropertiesExcept("id", "firstName", "lastName", "email", "phone", "lifeTimeValue", "orderHistory");
        Assertions.assertThat(customerOrderHistory).hasFieldOrPropertyWithValue("id", 485);
        Assertions.assertThat(customerOrderHistory).matches(customerDTO -> customerDTO.getOrderHistory().size() > 0);
    }
}