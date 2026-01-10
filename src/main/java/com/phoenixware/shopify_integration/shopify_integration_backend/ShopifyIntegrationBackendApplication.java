package com.phoenixware.shopify_integration.shopify_integration_backend;

import com.phoenixware.shopify_integration.shopify_integration_backend.dao.OrderDAO;
import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ShopifyIntegrationBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopifyIntegrationBackendApplication.class, args);
    }
}
