package com.bigcommerce.service;

import com.bigcommerce.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    /**
     * Returns a list containing all the BigCommerce customers {@code CustomerDTO}
     * with total number of orders placed by them.
     *
     * If {@code page} is greater than 0, it paginates the response by returning a smaller lists with size of 25 customers .
     * @param page - page number of the current page
     * @return {@link List<CustomerDTO>} of all customers if page = 0, otherwise 25 customers if page > 0
     * @throws {@link RuntimeException} if calls to API are unsuccessful
     *
     */
    List<CustomerDTO> getCustomersWithTheirTotalNoOfOrders(int page);


    /**
     * Returns a {@link CustomerDTO} containing basic details of customers and
     * {@link List<com.bigcommerce.dto.OrderDTO>} of all orders placed by him/her.
     *
     * @param customerId - Id of the customer whose details are requested
     * @return {@link CustomerDTO} if successful and customer is present for this id
     * @throws {@link RuntimeException} either if customer is absent or API calls are unsuccessful
     */
    CustomerDTO getCustomerOrderHistory(String customerId);

}
