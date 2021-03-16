package com.bigcommerce.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponse {

    @JsonProperty("billing_address")
    private BillingAddress billingAddress;

    @JsonProperty("coupon_discount")
    private String couponDiscount;

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("customer_message")
    private String customerMessage;

    @JsonProperty("default_currency_code")
    private String defaultCurrencyCode;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("date_shipped")
    private String dateShipped;

    @JsonProperty("id")
    private int id;

    @JsonProperty("items_shipped")
    private int itemsShipped;

    @JsonProperty("items_total")
    private int itemsTotal;

    @JsonProperty("payment_status")
    private String paymentStatus;

    @JsonProperty("store_credit_amount")
    private String storeCreditAmount;

    @JsonProperty("geoip_country")
    private String geoipCountry;

    @JsonProperty("refunded_amount")
    private String refundedAmount;

    @JsonProperty("status")
    private String status;

    @JsonProperty("shipping_cost_inc_tax")
    private String shippingCostIncTax;

    @JsonProperty("total_ex_tax")
    private String totalExTax;

    @JsonProperty("total_tax")
    private String totalTax;

    @JsonProperty("total_inc_tax")
    private String totalIncTax;

    public String getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(String dateShipped) {
        this.dateShipped = dateShipped;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public int getItemsTotal() {
        return itemsTotal;
    }

    public void setItemsTotal(int itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public String getTotalExTax() {
        return totalExTax;
    }

    public void setTotalExTax(String totalExTax) {
        this.totalExTax = totalExTax;
    }

    public String getStoreCreditAmount() {
        return storeCreditAmount;
    }

    public void setStoreCreditAmount(String storeCreditAmount) {
        this.storeCreditAmount = storeCreditAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGeoipCountry() {
        return geoipCountry;
    }

    public void setGeoipCountry(String geoipCountry) {
        this.geoipCountry = geoipCountry;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(String refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public int getItemsShipped() {
        return itemsShipped;
    }

    public void setItemsShipped(int itemsShipped) {
        this.itemsShipped = itemsShipped;
    }

    public String getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(String couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalIncTax() {
        return totalIncTax;
    }

    public void setTotalIncTax(String totalIncTax) {
        this.totalIncTax = totalIncTax;
    }

    public String getDefaultCurrencyCode() {
        return defaultCurrencyCode;
    }

    public void setDefaultCurrencyCode(String defaultCurrencyCode) {
        this.defaultCurrencyCode = defaultCurrencyCode;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getShippingCostIncTax() {
        return shippingCostIncTax;
    }

    public void setShippingCostIncTax(String shippingCostIncTax) {
        this.shippingCostIncTax = shippingCostIncTax;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "customerId=" + customerId +
                ", id=" + id +
                ", itemsShipped=" + itemsShipped +
                ", itemsTotal=" + itemsTotal +
                ", status='" + status + '\'' +
                ", totalIncTax='" + totalIncTax + '\'' +
                '}';
    }
}