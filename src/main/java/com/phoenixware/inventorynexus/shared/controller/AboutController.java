package com.phoenixware.inventorynexus.shared.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RestController
public class AboutController {

    @GetMapping("/about")
    public String getAbout() {
        return "Welcome to the Inventory Nexus, a one stop shop to all of your e-commerce needs.";
    }
}
