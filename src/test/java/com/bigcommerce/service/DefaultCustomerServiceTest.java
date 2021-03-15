package com.bigcommerce.service;

import com.bigcommerce.dao.CustomerResponse;
import com.bigcommerce.dto.CustomerDTO;
import com.bigcommerce.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class DefaultCustomerServiceTest {

    @Mock
    private CustomerRepository customerWebRepository;


    @InjectMocks
    private DefaultCustomerService customerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getCustomersWithTheirTotalNoOfOrders() {

    }

    @Test
    void getCustomerOrderHistoryShouldReturnCustomerDTO() {
        String customerId = "123";
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(Integer.parseInt(customerId));

        when(customerWebRepository.getCustomer(customerId)).thenReturn(customerResponse);
        when(customerWebRepository.getOrders(customerId)).thenReturn(anyList());
        CustomerDTO customerOrderHistory = customerService.getCustomerOrderHistory(customerId);

        Assertions.assertThat(customerOrderHistory).hasFieldOrPropertyWithValue("id", 123);

    }
}