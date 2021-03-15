package com.bigcommerce.controller;

import com.bigcommerce.dto.CustomerDTO;
import com.bigcommerce.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{customerId}/orderHistory")
    public String getCustomerOrderHistory(@PathVariable("customerId") String customerId, Model model) {
        LOGGER.trace("CustomerId: {}", customerId);
        model.addAttribute("customerOrderHistory", customerService.getCustomerOrderHistory(customerId));
        return "customerOrderHistory";
    }

    @GetMapping("/customers")
    public String getCustomers(@RequestParam(value = "page", required = false, defaultValue = "0") int page,Model model) {
        LOGGER.trace("Request received for getting all the customers");
        List<CustomerDTO> customers = customerService.getCustomersWithTheirTotalNoOfOrders(page);
        model.addAttribute("customers", customers);
        return "customers";
    }
}
