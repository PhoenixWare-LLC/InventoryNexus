package com.phoenixware.inventorynexus.shared.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneTimeTokenController {

    @GetMapping("/ott/sent")
    public String tokenSent() {
        return "Your token has been sent";
    }
}
