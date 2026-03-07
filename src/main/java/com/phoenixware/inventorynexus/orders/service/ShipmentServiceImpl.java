package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.shipment.ShipmentDTO;
import com.phoenixware.inventorynexus.orders.entity.Shipment;
import com.phoenixware.inventorynexus.orders.exception.shipment.ShipmentNotFoundException;
import com.phoenixware.inventorynexus.orders.mapper.ShipmentMapper;
import com.phoenixware.inventorynexus.orders.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService{
    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper shipmentMapper;

    @Override
    public ShipmentDTO create(ShipmentDTO shipmentDTO) {
        return shipmentMapper.shipmentToShipmentDto(
                shipmentRepository.save(
                        shipmentMapper.shipmentDtoToShipment(
                                shipmentDTO
                        )
                )
        );
    }

    @Override
    public ShipmentDTO updateById(UUID id, ShipmentDTO shipmentDTO) {
        Shipment existingShipment = shipmentRepository.findById(id)
                .orElseThrow(ShipmentNotFoundException::new);

        Shipment updatedShipment = shipmentMapper.shipmentDtoToShipment(shipmentDTO);
        updatedShipment.setId(id);

        shipmentRepository.save(updatedShipment);

        Shipment shipmentFromDb = shipmentRepository.findById(id)
                .orElseThrow(ShipmentNotFoundException::new);

        return shipmentMapper.shipmentToShipmentDto(shipmentFromDb);
    }

    @Override
    public ShipmentDTO patchById(UUID id, ShipmentDTO shipmentDTO) {
        Shipment existingShipment = shipmentRepository.findById(id)
                .orElseThrow(ShipmentNotFoundException::new);

        Shipment patchedShipment = shipmentMapper.patchShipmentFromShipmentDto(shipmentDTO, existingShipment);

        shipmentRepository.save(patchedShipment);

        Shipment shipmentFromDb = shipmentRepository.findById(id)
                .orElseThrow(ShipmentNotFoundException::new);

        return shipmentMapper.shipmentToShipmentDto(shipmentFromDb);
    }

    @Override
    public ShipmentDTO findById(UUID id) {
        return shipmentMapper.shipmentToShipmentDto(
                shipmentRepository.findById(id)
                        .orElseThrow(ShipmentNotFoundException::new)
        );
    }

    @Override
    public List<ShipmentDTO> findAll() {
        return shipmentRepository
                .findAll()
                .stream()
                .map(shipmentMapper::shipmentToShipmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (shipmentRepository.existsById(id)) {
            shipmentRepository.deleteById(id);
        } else {
            throw new ShipmentNotFoundException();
        }

    }
}
