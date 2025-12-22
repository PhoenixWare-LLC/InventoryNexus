package com.phoenixware.shopify_integration.shopify_integration_backend.service;


public class ShopifyFulfillOrder implements PerformAPICall {

    public ShopifyFulfillOrder() {
        System.out.println( "FulfillOrder constructor called");
    }
    @Override
    public String getAPIEndpoint() {
        return "shopifyFulfillOrder";
    }
}
