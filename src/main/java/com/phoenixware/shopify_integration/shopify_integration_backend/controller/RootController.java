package com.phoenixware.shopify_integration.shopify_integration_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String root() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String GymWelcoming() {
        return "Welcome to the jungle!";
    }
}
