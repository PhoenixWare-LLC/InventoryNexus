package com.phoenixware.inventorynexus.personnel.service;

import com.phoenixware.inventorynexus.personnel.dto.contractor.ContractorDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface ContractorService {
    ContractorDTO create(ContractorDTO contractorDTO);
    ContractorDTO updateById(UUID id,ContractorDTO contractorDTO);
    ContractorDTO patchById(UUID id, ContractorDTO contractorDTO);
    ContractorDTO findById(UUID id);
    List<ContractorDTO> findAll();
    void deleteById(UUID id);
}
