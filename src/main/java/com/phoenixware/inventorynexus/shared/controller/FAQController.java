package com.phoenixware.inventorynexus.shared.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RestController
public class FAQController {

    @GetMapping("/faq")
    public String getFaq() {
        return "This is going to be where I have the frequently asked questions and their answers about this product.";
    }
}
