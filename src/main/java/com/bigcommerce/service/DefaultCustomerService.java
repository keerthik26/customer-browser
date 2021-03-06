package com.bigcommerce.service;

import com.bigcommerce.dao.CustomerResponse;
import com.bigcommerce.dao.OrderResponse;
import com.bigcommerce.dto.CustomerDTO;
import com.bigcommerce.dto.OrderDTO;
import com.bigcommerce.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DefaultCustomerService implements CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultCustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * For this, it retrieves all the orders using Orders API and groups them by customer ids
     * and all customers by calling Customers API to fetch their basic details.
     *
     */
    @Override
    public List<CustomerDTO> getCustomersWithTheirTotalNoOfOrders(int page) {

        Map<Integer, Long> noOfOrdersByCustomerId = customerRepository.getOrders().stream().collect(groupingBy(OrderResponse::getCustomerId, counting()));
        List<CustomerResponse> customerResponse = customerRepository.getCustomers(page);
        List<CustomerDTO> customers = customerResponse.stream().map(response -> {
            return toCustomerDTOWithNoOfOrders(noOfOrdersByCustomerId.getOrDefault(response.getId(), 0L), response);
        }).collect(Collectors.toList());
        LOGGER.info("Total no.of customers: {} ", customers.size());
        return customers;
    }


    /**
     * For this, it retrieves all the orders of customers by calling Orders API with customer id as request parameter
     * and Customers API to fetch the client's basic details.
     *
     * Calculates the life time value of customer by summing up {@code totalIncTax} from their {@link OrderResponse}
     *
     */
    @Override
    public CustomerDTO getCustomerOrderHistory(String customerId) {
        CustomerResponse customerResponse = customerRepository.getCustomer(customerId);
        List<OrderResponse> ordersResponse = customerRepository.getOrders(customerId);
        CustomerDTO customer = toCustomerDTO(customerResponse);
        customer.setOrderHistory(ordersResponse.stream().map(response -> {
            return toOrderDTO(response);
        }).collect(Collectors.toList()));
        customer.setLifeTimeValue(customer.getOrderHistory().stream().mapToDouble(OrderDTO::getTotalValue).sum());
        LOGGER.trace("CustomerDTO for customerId={} is {}", customerId, customer);
        return customer;
    }

    private static CustomerDTO toCustomerDTO(CustomerResponse customerResponse) {
        CustomerDTO customer = new CustomerDTO(customerResponse.getId(), customerResponse.getFirstName(), customerResponse.getLastName());
        customer.setEmail(customerResponse.getEmail());
        customer.setPhone(customerResponse.getPhone());
        return customer;
    }

    private static CustomerDTO toCustomerDTOWithNoOfOrders(Long noOfOrdersByCustomerId, CustomerResponse response) {
        CustomerDTO customer = toCustomerDTO(response);
        customer.setTotalNoOfOrders(noOfOrdersByCustomerId);
        return customer;
    }

    private static OrderDTO toOrderDTO(OrderResponse response) {
        OrderDTO order = new OrderDTO();
        order.setId(response.getId());
        order.setStatus(response.getStatus());
        order.setItemsTotal(response.getItemsTotal());
        order.setItemsShipped(response.getItemsShipped());
        order.setTotalBeforeTax(Double.parseDouble(response.getTotalExTax()));
        order.setTax(Double.parseDouble(response.getTotalTax()));
        order.setTotalValue(Double.parseDouble(response.getTotalIncTax()));
        order.setCurrency(response.getDefaultCurrencyCode());
        return order;
    }
}
