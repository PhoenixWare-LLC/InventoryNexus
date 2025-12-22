package com.phoenixware.shopify_integration.shopify_integration_backend.service;

import org.springframework.stereotype.Component;

@Component
public class ShopifyPerformOrderItems implements PerformAPICall {
    @Override
    public String getAPIEndpoint() {
        return "shopifyGetOrderItems";
    }
}
