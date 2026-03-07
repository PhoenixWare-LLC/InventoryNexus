package com.phoenixware.inventorynexus.personnel.mapper;

import com.phoenixware.inventorynexus.personnel.dto.contractor.ContractorDTO;
import com.phoenixware.inventorynexus.personnel.entity.Contractor;
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
public interface ContractorMapper {
    Contractor contractorDtoToContractor(ContractorDTO contractorDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contractor patchContractorFromContractorDto(ContractorDTO contractorDTO, @MappingTarget Contractor contractor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ContractorDTO patchContractorDtoFromContractor(Contractor contractor, @MappingTarget ContractorDTO contractorDTO);

    ContractorDTO contractorToContractorDto(Contractor contractor);
}
