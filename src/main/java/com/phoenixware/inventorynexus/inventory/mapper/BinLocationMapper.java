package com.phoenixware.inventorynexus.inventory.mapper;

import com.phoenixware.inventorynexus.inventory.dto.binlocation.BinLocationDTO;
import com.phoenixware.inventorynexus.inventory.entity.BinLocation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@Mapper
public interface BinLocationMapper {
    BinLocation binLocationDtoToBinLocation(BinLocationDTO binLocationDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BinLocation patchBinLocationFromBinLocationDto(BinLocationDTO binLocationDTO, @MappingTarget BinLocation binLocation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BinLocationDTO patchBinLocationDtoFromBinLocation(BinLocation binLocation, @MappingTarget BinLocationDTO binLocationDTO);

    BinLocationDTO binLocationToBinLocationDto(BinLocation binLocation);
}
