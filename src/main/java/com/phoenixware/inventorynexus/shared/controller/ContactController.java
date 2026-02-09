package com.phoenixware.inventorynexus.shared.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RestController
public class ContactController {

    @GetMapping("/contact")
    public String contactForm() {
        return "This will be the page where the form of contact will come into play.. yay.";
    }

}
