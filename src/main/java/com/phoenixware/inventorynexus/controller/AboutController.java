package com.phoenixware.inventorynexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @GetMapping("/about")
    public String getAbout() {
        return "Welcome to the Inventory Nexus, a one stop shop to all of your e-commerce needs.";
    }
}
