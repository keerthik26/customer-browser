package com.bigcommerce.repository;

import com.bigcommerce.dao.CustomerResponse;
import com.bigcommerce.dao.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RestCustomerRepository implements CustomerRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestCustomerRepository.class);

    @Autowired
    private WebClient webClient;

    @Override
    public List<CustomerResponse> getCustomers(int page) {
        List<CustomerResponse> customers = new ArrayList<>();
        boolean isPaginated = false;
        int pageNum = 1;
        int limit = 250;
        if (page > 0) {
            pageNum = page;
            limit = 25;
            isPaginated = true;
        }

        String customerUrl = "/customers?page={pageNum}&limit={limit}";

        List<CustomerResponse> responseEntityBody;
        do {
            Mono<ResponseEntity<List<CustomerResponse>>> responseEntityMono = webClient.get()
                    .uri(customerUrl, pageNum, limit)
                    .exchangeToMono(response -> {
                                if (response.statusCode().equals(HttpStatus.OK)) {
                                    return response.toEntity(new ParameterizedTypeReference<List<CustomerResponse>>() {
                                    });
                                } else {
                                    LOGGER.error("Unexpected Status: {}", response.statusCode());
                                    return Mono.error(RuntimeException::new);
                                }
                            }

                    );

            ResponseEntity<List<CustomerResponse>> responseEntity = responseEntityMono.block();
            LOGGER.trace("Customer List Response Entity: {}", responseEntity);
            responseEntityBody = responseEntity.getBody();
            customers.addAll(responseEntityBody);
            pageNum++;
        } while (!isPaginated && responseEntityBody.size() == 250);

        return customers;

    }

    @Override
    public CustomerResponse getCustomer(String customerId) {

        String customerUrl = "/customers/{customerId}";

        Mono<CustomerResponse> customerMono = webClient.get()
                .uri(customerUrl, Collections.singletonMap("customerId", customerId))
                .exchangeToMono(response -> {
                            if (response.statusCode().equals(HttpStatus.OK)) {
                                return response.bodyToMono(CustomerResponse.class);
                            } else {
                                LOGGER.error("Unexpected Status: {}", response.statusCode());
                                return Mono.error(RuntimeException::new);
                            }
                        }

                );

        CustomerResponse customer = customerMono.block();
        LOGGER.trace("Customer Response: {}", customer);

        return customer;
    }

    @Override
    public List<OrderResponse> getOrders() {
        List<OrderResponse> orders = new ArrayList<>();
        int pageNum = 1;
        String ordersUri = "/orders?page={pageNum}&limit=250";
        List<OrderResponse> ordersResponse;
        do {
            Mono<List<OrderResponse>> orderListMono = webClient.get()
                    .uri(ordersUri, pageNum)
                    .exchangeToMono(response -> {
                        if (response.statusCode().equals(HttpStatus.OK)) {
                            return response.bodyToMono(new ParameterizedTypeReference<List<OrderResponse>>() {
                            });
                        } else {
                            return Mono.error(RuntimeException::new);
                        }
                    });

            ordersResponse = orderListMono.block();
            LOGGER.info("Order List Response Entity: {}", ordersResponse);
            orders.addAll(ordersResponse);
            pageNum++;
        } while (ordersResponse.size() == 250);
        return orders;
    }

    @Override
    public List<OrderResponse> getOrders(String customerId) {
        List<OrderResponse> orders = new ArrayList<>();
        int pageNum = 1;
        String customerOrdersUri = "/orders?customer_id={customerId}&page={pageNum}&limit=250";
        List<OrderResponse> ordersResponse;
        do {
            Mono<List<OrderResponse>> orderListMono = webClient.get()
                    .uri(customerOrdersUri, customerId, pageNum)
                    .exchangeToMono(response -> {
                        if (response.statusCode().equals(HttpStatus.OK)) {
                            return response.bodyToMono(new ParameterizedTypeReference<List<OrderResponse>>() {
                            });
                        } else if (response.statusCode().equals(HttpStatus.NO_CONTENT)) {
                            return Mono.fromSupplier(ArrayList::new);
                        } else {
                            return Mono.error(RuntimeException::new);
                        }
                    });

            ordersResponse = orderListMono.block();
            LOGGER.info("Order List Response Entity: {}", ordersResponse);
            orders.addAll(ordersResponse);
            pageNum++;
        } while (ordersResponse.size() == 250);
        return orders;
    }


}
