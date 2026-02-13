package com.phoenixware.inventorynexus.shared.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@RestController
public class AdminController {

    @GetMapping("/admin")
    public String getAdmin() {
        return "You made it!";
    }
}
