package com.phoenixware.inventorynexus.repository;

import com.phoenixware.inventorynexus.entity.ShipmentPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentPackageRepository extends JpaRepository<ShipmentPackage, String> {
}
