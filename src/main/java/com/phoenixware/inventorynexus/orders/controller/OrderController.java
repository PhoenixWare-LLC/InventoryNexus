package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDetailedDTO;
import com.phoenixware.inventorynexus.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDetailedDTO> getOrder(@PathVariable("id") UUID id) {
        OrderDetailedDTO orderDetailedDTO = orderService.findById(id);
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/orders/" + orderDetailedDTO.getId());
        
        ResponseEntity<OrderDetailedDTO> responseEntity = new ResponseEntity<>(
                orderDetailedDTO,
                httpHeaders,
                HttpStatus.OK
        );
        
        return responseEntity;
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderDetailedDTO> updateOrder(@PathVariable("id") UUID id, @RequestBody OrderDetailedDTO orderDetailedDTO) {
        OrderDetailedDTO updatedOrderDetailedDTO = orderService.updateById(id, orderDetailedDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/orders/" + updatedOrderDetailedDTO.getId());

        ResponseEntity<OrderDetailedDTO> responseEntity = new ResponseEntity<>(
                updatedOrderDetailedDTO,
                httpHeaders, 
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/orders/{id}")
    public ResponseEntity<OrderDetailedDTO> patchOrder(@PathVariable("id") UUID id, @RequestBody OrderDetailedDTO orderDetailedDTO) {
        OrderDetailedDTO patchedOrderDetailedDTO = orderService.patchById(id, orderDetailedDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/orders/" + patchedOrderDetailedDTO.getId());

        ResponseEntity<OrderDetailedDTO> responseEntity = new ResponseEntity<>(
                patchedOrderDetailedDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDetailedDTO> postOrder(@RequestBody OrderDetailedDTO orderDetailedDTO) {
        OrderDetailedDTO postedOrderDetailedDTO = orderService.create(orderDetailedDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/orders/" + postedOrderDetailedDTO.getId());

        ResponseEntity<OrderDetailedDTO> responseEntity = new ResponseEntity<>(
                postedOrderDetailedDTO, httpHeaders, HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/orders/{order_id}")
    public ResponseEntity<OrderDetailedDTO> deleteById(@PathVariable("order_id") UUID id) {
        orderService.deleteById(id);

        ResponseEntity<OrderDetailedDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
