package com.phoenixware.shopify_integration.shopify_integration_backend.config;

import com.phoenixware.shopify_integration.shopify_integration_backend.service.PerformAPICall;
import com.phoenixware.shopify_integration.shopify_integration_backend.service.ShopifyFulfillOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {

    //Testing working branch
    @Bean("fulfillment")
    public PerformAPICall shopifyFulfillOrder() {
        return new ShopifyFulfillOrder();
    }
}
