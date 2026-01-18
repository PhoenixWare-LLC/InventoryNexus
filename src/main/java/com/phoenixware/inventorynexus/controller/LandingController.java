package com.phoenixware.inventorynexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingController {
    @GetMapping("/")
    public String getLanding() {
        return "this will have any new information we might need to display on the home page, to make this more of a dynamic content.";
    }
}
