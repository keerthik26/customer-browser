package com.bigcommerce.repository;

import com.bigcommerce.dao.CustomerResponse;
import com.bigcommerce.dao.OrderResponse;

import java.util.List;

public interface CustomerRepository {

    List<CustomerResponse> getCustomers(int page);

    CustomerResponse getCustomer(String customerId);

    List<OrderResponse> getOrders();

    List<OrderResponse> getOrders(String customerId);

}
