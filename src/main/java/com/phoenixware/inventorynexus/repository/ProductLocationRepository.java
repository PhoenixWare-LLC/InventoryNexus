package com.phoenixware.inventorynexus.repository;

import com.phoenixware.inventorynexus.entity.ProductLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLocationRepository extends JpaRepository<ProductLocation, String> {
}
