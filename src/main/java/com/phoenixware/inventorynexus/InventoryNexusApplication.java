package com.phoenixware.inventorynexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@SpringBootApplication
@EnableScheduling
public class   InventoryNexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryNexusApplication.class, args);
    }
}
