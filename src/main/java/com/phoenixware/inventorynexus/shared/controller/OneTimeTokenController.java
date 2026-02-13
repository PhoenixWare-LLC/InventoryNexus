package com.phoenixware.inventorynexus.shared.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@RestController
public class OneTimeTokenController {

    @GetMapping("/ott/sent")
    public String tokenSent() {
        return "Your token has been sent";
    }
}
