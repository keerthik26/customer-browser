package com.bigcommerce.service;

import com.bigcommerce.dao.CustomerResponse;
import com.bigcommerce.dao.OrderResponse;
import com.bigcommerce.dto.CustomerDTO;
import com.bigcommerce.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

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
        List<OrderResponse> orders = new ArrayList<>();
        OrderResponse order1 = new OrderResponse();
        order1.setCustomerId(123);
        orders.add(order1);
        OrderResponse order2 = new OrderResponse();
        order2.setCustomerId(456);
        orders.add(order2);

        CustomerResponse customer1 = new CustomerResponse();
        customer1.setId(123);
        CustomerResponse customer2 = new CustomerResponse();
        customer2.setId(456);
        CustomerResponse customer3 = new CustomerResponse();
        customer3.setId(556);
        ArrayList<CustomerResponse> customerResponses = new ArrayList<CustomerResponse>() {{
            add(customer1);
            add(customer2);
            add(customer3);
        }};
        when(customerWebRepository.getOrders()).thenReturn(orders);
        when(customerWebRepository.getCustomers(0)).thenReturn(customerResponses);

        List<CustomerDTO> response = customerService.getCustomersWithTheirTotalNoOfOrders(0);

        Assertions.assertThat(response).hasSize(3);
        Assertions.assertThat(response).filteredOn(customerDTO -> customerDTO.getId() == 556).allMatch(customerDTO -> customerDTO.getTotalNoOfOrders() == 0);
        Assertions.assertThat(response).filteredOn(customerDTO -> customerDTO.getId() != 556).allMatch(customerDTO -> customerDTO.getTotalNoOfOrders() == 1);
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