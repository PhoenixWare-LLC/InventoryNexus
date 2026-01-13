package com.phoenixware.inventorynexus.repository;

import com.phoenixware.inventorynexus.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
