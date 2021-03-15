package com.bigcommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private int id;
    private String customerId;
    private String status;
    private String currency;
    private int itemsTotal;
    private int itemsShipped;
    private Double totalBeforeTax;
    private Double totalValue;
    private Double tax;

    public OrderDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double value) {
        this.totalValue = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setItemsTotal(int itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public int getItemsTotal() {
        return itemsTotal;
    }

    public void setItemsShipped(int itemsShipped) {
        this.itemsShipped = itemsShipped;
    }

    public int getItemsShipped() {
        return itemsShipped;
    }
    public void setTotalBeforeTax(Double totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }

    public Double getTotalBeforeTax() {
        return totalBeforeTax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
