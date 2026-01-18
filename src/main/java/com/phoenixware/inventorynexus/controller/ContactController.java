package com.phoenixware.inventorynexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String contactForm() {
        return "This will be the page where the form of contact will come into play.. yay.";
    }

}
