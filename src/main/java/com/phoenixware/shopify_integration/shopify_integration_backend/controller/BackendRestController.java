package com.phoenixware.shopify_integration.shopify_integration_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BackendRestController {
    // add code for the /status endpoint

    @GetMapping("/status")
    public String returnStatus() {
        return "Up";
    }
}
