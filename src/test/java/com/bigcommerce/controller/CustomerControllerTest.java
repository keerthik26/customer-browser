package com.bigcommerce.controller;

import com.bigcommerce.dto.CustomerDTO;
import com.bigcommerce.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;


    @Test
    void getCustomerOrderHistoryShouldReturnCustomerOrderHistory() throws Exception {
        String customerId = "485";
        CustomerDTO mockResponse = new CustomerDTO(Integer.parseInt(customerId), "Sarah", "K");
        mockResponse.setEmail("sarah.k@email.com");
        mockResponse.setLifeTimeValue(0.00);
        mockResponse.setOrderHistory(Collections.EMPTY_LIST);
        when(customerService.getCustomerOrderHistory(customerId)).thenReturn(mockResponse);

        mockMvc.perform(get("/customers/" + customerId + "/orderHistory"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customerOrderHistory"))
                .andExpect(view().name("customerOrderHistory"));
    }

    @Test
    void getCustomerOrderHistoryShouldReturnHtmlPageForNonExistingUser() throws Exception {

    }

    @Test
    void getCustomersShouldReturnCustomers() throws Exception {
        when(customerService.getCustomersWithTheirTotalNoOfOrders(1)).thenReturn(anyList());
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customers"))
                .andExpect(view().name("customers"));
    }
}