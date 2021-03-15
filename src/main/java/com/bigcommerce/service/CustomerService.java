package com.bigcommerce.service;

import com.bigcommerce.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getCustomersWithTheirTotalNoOfOrders(int page);

    CustomerDTO getCustomerOrderHistory(String customerId);

}
