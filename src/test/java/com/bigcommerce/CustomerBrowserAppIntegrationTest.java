package com.bigcommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerBrowserAppIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCustomerShouldReturnCustomersView() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers"));
    }

    @Test
    public void testGetCustomerWithPaginationShouldReturnCustomersView() throws Exception {
        int pageNum = 2;
        mockMvc.perform(get("/customers?page=" + 2))
                .andExpect(status().isOk())
                .andExpect(view().name("customers"));
    }

    @Test
    void testGetCustomerOrderHistoryForExistingIdShouldReturnView() throws Exception {
        int customerId = 123;
        mockMvc.perform(get("/customers/" + customerId + "/orderHistory"))
                .andExpect(status().isOk())
                .andExpect(view().name("customerOrderHistory"));
    }

    @Test
    void testGetCustomerOrderHistoryForNonExistingIdShouldReturnErrorView() throws Exception {
        int customerId = 1234;
        mockMvc.perform(get("/customers/" + customerId + "/orderHistory"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }
}
