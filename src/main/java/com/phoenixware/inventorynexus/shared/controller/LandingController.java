package com.phoenixware.inventorynexus.shared.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RestController
public class LandingController {
    @GetMapping("/")
    public String getLanding() {
        return "this will have any new information we might need to display on the home page, to make this more of a dynamic content.";
    }
}
