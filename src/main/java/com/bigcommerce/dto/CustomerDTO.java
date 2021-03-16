package com.bigcommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long totalNoOfOrders;
    private List<OrderDTO> orderHistory;
    private Double lifeTimeValue;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getTotalNoOfOrders() {
        return totalNoOfOrders;
    }

    public void setTotalNoOfOrders(Long totalNoOfOrders) {
        this.totalNoOfOrders = totalNoOfOrders;
    }

    public List<OrderDTO> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<OrderDTO> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Double getLifeTimeValue() {
        return lifeTimeValue;
    }

    public void setLifeTimeValue(Double lifeTimeValue) {
        this.lifeTimeValue = lifeTimeValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", totalNoOfOrders=" + totalNoOfOrders +
                ", orderHistory=" + orderHistory +
                ", lifeTimeValue=" + lifeTimeValue +
                '}';
    }
}
