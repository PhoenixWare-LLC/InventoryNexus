package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.mapper.OrderItemMapper;
import com.phoenixware.inventorynexus.orders.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Service
@Primary
@RequiredArgsConstructor
public class OrderItemServiceJPA implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

}
