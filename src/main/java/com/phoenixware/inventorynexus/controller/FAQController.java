package com.phoenixware.inventorynexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FAQController {

    @GetMapping("/faq")
    public String getFaq() {
        return "This is going to be where I have the frequently asked questions and their answers about this product.";
    }
}
