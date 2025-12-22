package com.phoenixware.shopify_integration.shopify_integration_backend;

import com.phoenixware.shopify_integration.shopify_integration_backend.dao.OrderDAO;
import com.phoenixware.shopify_integration.shopify_integration_backend.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopifyIntegrationBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopifyIntegrationBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(OrderDAO orderDAO) {
        return runner -> {
            getOrder(orderDAO);
        };
    }

    private void getOrder(OrderDAO orderDAO) {
        System.out.println("Getting order");
        Order order = orderDAO.getOrderById(1);
        System.out.println("Order: " + order);
    }
    private void createOrder(OrderDAO orderDAO) {
        System.out.println("Creating order");
        Order order = new Order("John Doe", "777 Spring Creek dr", "", "Phoenix", "AZ", "85392", 99.95);

        System.out.println("Saving order");
        orderDAO.saveOrder(order);

        System.out.println("Order saved" + order.getId());
    }
}
