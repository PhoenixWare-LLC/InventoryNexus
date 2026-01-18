package com.phoenixware.inventorynexus.repository;

import com.phoenixware.inventorynexus.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
