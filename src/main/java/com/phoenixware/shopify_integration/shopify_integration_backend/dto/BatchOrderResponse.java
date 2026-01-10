package com.phoenixware.shopify_integration.shopify_integration_backend.dto;

import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;

import java.util.List;

public class BatchOrderResponse {
    private int successful;
    private int unsuccessful;
    private List<Order> successfulOrders;
    private List<Order> unsuccessfulOrders;

    public BatchOrderResponse(int successful, int unsuccessful, List<Order> successfulOrders, List<Order> unsuccessfulOrders) {
        this.successful = successful;
        this.unsuccessful = unsuccessful;
        this.successfulOrders = successfulOrders;
        this.unsuccessfulOrders = unsuccessfulOrders;
    }

    public int getSuccessful() {
        return successful;
    }

    public void setSuccessful(int successful) {
        this.successful = successful;
    }

    public int getUnsuccessful() {
        return unsuccessful;
    }

    public void setUnsuccessful(int unsuccessful) {
        this.unsuccessful = unsuccessful;
    }

    public List<Order> getSuccessfulOrders() {
        return successfulOrders;
    }

    public void setSuccessfulOrders(List<Order> successfulOrders) {
        this.successfulOrders = successfulOrders;
    }

    public List<Order> getUnsuccessfulOrders() {
        return unsuccessfulOrders;
    }

    public void setUnsuccessfulOrders(List<Order> unsuccessfulOrders) {
        this.unsuccessfulOrders = unsuccessfulOrders;
    }
}
