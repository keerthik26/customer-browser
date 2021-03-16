package com.bigcommerce.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponse {

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("id")
    private int id;

    @JsonProperty("store_credit")
    private String storeCredit;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("email")
    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreCredit() {
        return storeCredit;
    }

    public void setStoreCredit(String storeCredit) {
        this.storeCredit = storeCredit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", storeCredit='" + storeCredit + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}