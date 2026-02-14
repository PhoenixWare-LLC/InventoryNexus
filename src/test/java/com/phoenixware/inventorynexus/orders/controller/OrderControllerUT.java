package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.OrderDTO;
import com.phoenixware.inventorynexus.orders.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/14/2026
 */
@WebMvcTest(OrderController.class)
public class OrderControllerUT {
    @Autowired
    private OrderController orderController;

    @MockitoBean
    private OrderService orderService;

    @Test
    void putById_shouldReturn202AndUpdateName() {
        UUID orderId = UUID.randomUUID();

        OrderDTO inputOrderDTO = OrderDTO.builder()
                .id(null)
                .name("Updated Order")
                .city("Some city")
                .state("MT")
                .fulfilled(false)
                .marketplace("Amazon")
                .street1("123 My Awesome St")
                .postalCode("98265")
                .total(BigDecimal.valueOf(55.55))
                .shipped(false)
                .trackingNumber("ahhh")
                .build();

        OrderDTO outputOrderDTO = OrderDTO.builder()
                .id(orderId)
                .name("Updated Order")
                .city("Some city")
                .state("MT")
                .fulfilled(false)
                .marketplace("Amazon")
                .street1("123 My Awesome St")
                .postalCode("98265")
                .total(BigDecimal.valueOf(55.55))
                .shipped(false)
                .trackingNumber("ahhh")
                .build();

        given(orderService.putById(orderId, inputOrderDTO)).willReturn(outputOrderDTO);

        ResponseEntity<?> responseEntity = orderController.putById(orderId, inputOrderDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(responseEntity.getHeaders().getFirst("Location")).isEqualTo("/orders/" + orderId);
        assertThat(responseEntity.getBody()).isEqualTo(outputOrderDTO);

        verify(orderService).putById(eq(orderId), eq(inputOrderDTO));

    }
}
