package com.phoenixware.shopify_integration.shopify_integration_backend.controller;

import com.phoenixware.shopify_integration.shopify_integration_backend.service.PerformAPICall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    //define private field for dependency
    private PerformAPICall theAPICall;

    @Autowired
    public APIController(@Qualifier("fulfillment") PerformAPICall APICallPerforming) {
        theAPICall = APICallPerforming;
    }

    @GetMapping("/api")
    public String getAPICall() {
        return theAPICall.getAPIEndpoint();
    }

}
