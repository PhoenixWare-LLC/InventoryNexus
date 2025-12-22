package com.phoenixware.shopify_integration.shopify_integration_backend.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ShopifyPerformOrders implements PerformAPICall {
    @Override
    public String getAPIEndpoint() {
        return "shopifyGetOrders";
    }
}
