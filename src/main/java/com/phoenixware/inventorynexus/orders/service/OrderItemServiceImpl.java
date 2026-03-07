package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.orderitem.OrderItemDTO;
import com.phoenixware.inventorynexus.orders.entity.OrderItem;
import com.phoenixware.inventorynexus.orders.exception.orderitem.OrderItemNotFoundException;
import com.phoenixware.inventorynexus.orders.mapper.OrderItemMapper;
import com.phoenixware.inventorynexus.orders.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderItemDTO create(OrderItemDTO orderItemDTO) {
        return orderItemMapper.orderItemToOrderItemDto(
                orderItemRepository.save(
                        orderItemMapper.orderItemDtoToOrderItem(
                                orderItemDTO
                        )
                )
        );
    }

    @Override
    public OrderItemDTO updateById(UUID id, OrderItemDTO orderItemDTO) {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(OrderItemNotFoundException::new);

        OrderItem updateOrderItem = orderItemMapper.orderItemDtoToOrderItem(orderItemDTO);

        orderItemRepository.save(updateOrderItem);

        OrderItem orderItemFromDb = orderItemRepository.findById(id)
                .orElseThrow(OrderItemNotFoundException::new);

        return orderItemMapper.orderItemToOrderItemDto(orderItemFromDb);
    }

    @Override
    public OrderItemDTO patchById(UUID id, OrderItemDTO orderItemDTO) {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(OrderItemNotFoundException::new);

        OrderItem patchedOrderItem = orderItemMapper.patchOrderItemFromOrderItemDto(orderItemDTO, existingOrderItem);

        orderItemRepository.save(patchedOrderItem);

        OrderItem orderItemFromDb = orderItemRepository.findById(id)
                .orElseThrow(OrderItemNotFoundException::new);

        return orderItemMapper.orderItemToOrderItemDto(orderItemFromDb);
    }

    @Override
    public OrderItemDTO findById(UUID id) {
        return orderItemMapper.orderItemToOrderItemDto(
                orderItemRepository.findById(id)
                        .orElseThrow(OrderItemNotFoundException::new)
        );
    }

    @Override
    public List<OrderItemDTO> findAll() {
        return orderItemRepository
                .findAll()
                .stream()
                .map(orderItemMapper::orderItemToOrderItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
        } else {
            throw new OrderItemNotFoundException();
        }

    }
}
