package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.binlocation.BinLocationDTO;
import com.phoenixware.inventorynexus.inventory.entity.BinLocation;
import com.phoenixware.inventorynexus.inventory.exception.binlocation.BinLocationNotFoundException;
import com.phoenixware.inventorynexus.inventory.mapper.BinLocationMapper;
import com.phoenixware.inventorynexus.inventory.repository.BinLocationRepository;
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
public class BinLocationServiceImpl implements BinLocationService{
    private final BinLocationRepository binLocationRepository;
    private final BinLocationMapper binLocationMapper;

    @Override
    public BinLocationDTO create(BinLocationDTO binLocationDTO) {
        return binLocationMapper.binLocationToBinLocationDto(
                binLocationRepository.save(
                        binLocationMapper.binLocationDtoToBinLocation(binLocationDTO)
                )
        );
    }

    @Override
    public BinLocationDTO updateById(UUID id, BinLocationDTO binLocationDTO) {
        BinLocation existingBinLocation = binLocationRepository.findById(id)
                .orElseThrow(BinLocationNotFoundException::new);

        BinLocation updatedBinLocation = binLocationMapper.binLocationDtoToBinLocation(binLocationDTO);
        updatedBinLocation.setId(id);

        binLocationRepository.save(updatedBinLocation);

        BinLocation binLocationFromDb = binLocationRepository.findById(id)
                .orElseThrow(BinLocationNotFoundException::new);

        return binLocationMapper.binLocationToBinLocationDto(binLocationFromDb);
    }

    @Override
    public BinLocationDTO patchById(UUID id, BinLocationDTO binLocationDTO) {
        BinLocation existingBinLocation = binLocationRepository.findById(id)
                .orElseThrow(BinLocationNotFoundException::new);

        BinLocation patchedBinLocation = binLocationMapper.patchBinLocationFromBinLocationDto(binLocationDTO, existingBinLocation);

        binLocationRepository.save(patchedBinLocation);

        BinLocation binLocationFromDb = binLocationRepository.findById(id)
                .orElseThrow(BinLocationNotFoundException::new);

        return binLocationMapper.binLocationToBinLocationDto(binLocationFromDb);
    }

    @Override
    public BinLocationDTO findById(UUID id) {
        return binLocationMapper.binLocationToBinLocationDto(
                binLocationRepository.findById(id)
                        .orElseThrow(BinLocationNotFoundException::new)
        );
    }

    @Override
    public List<BinLocationDTO> findAll() {
        return binLocationRepository.
                findAll()
                .stream()
                .map(binLocationMapper::binLocationToBinLocationDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (binLocationRepository.existsById(id)) {
            binLocationRepository.deleteById(id);
        } else {
            throw new BinLocationNotFoundException();
        }
    }
}
