package com.phoenixware.inventorynexus.personnel.service;


import com.phoenixware.inventorynexus.personnel.dto.contractor.ContractorDTO;
import com.phoenixware.inventorynexus.personnel.entity.Contractor;
import com.phoenixware.inventorynexus.personnel.exception.contractor.ContractorNotFoundException;
import com.phoenixware.inventorynexus.personnel.mapper.ContractorMapper;
import com.phoenixware.inventorynexus.personnel.repository.ContractorRepository;
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
public class ContractorServiceImpl implements ContractorService{
    private final ContractorRepository contractorRepository;
    private final ContractorMapper contractorMapper;

    @Override
    public ContractorDTO create(ContractorDTO contractorDTO) {
        return contractorMapper.contractorToContractorDto(
                contractorRepository.save(
                        contractorMapper.contractorDtoToContractor(
                                contractorDTO
                        )
                )
        );
    }

    @Override
    public ContractorDTO updateById(UUID id, ContractorDTO contractorDTO) {
        Contractor existingContractor = contractorRepository.findById(id)
                .orElseThrow(ContractorNotFoundException::new);

        Contractor updatedContractor = contractorMapper.contractorDtoToContractor(contractorDTO);
        updatedContractor.setId(id);

        contractorRepository.save(updatedContractor);

        Contractor contractorFromDb = contractorRepository.findById(id)
                .orElseThrow(ContractorNotFoundException::new);

        return contractorMapper.contractorToContractorDto(contractorFromDb);
    }

    @Override
    public ContractorDTO patchById(UUID id, ContractorDTO contractorDTO) {
        Contractor existingContractor = contractorRepository.findById(id)
                .orElseThrow(ContractorNotFoundException::new);

        Contractor patchedContractor = contractorMapper.patchContractorFromContractorDto(contractorDTO, existingContractor);

        contractorRepository.save(patchedContractor);

        Contractor contractorFromDb = contractorRepository.findById(id)
                .orElseThrow(ContractorNotFoundException::new);

        return contractorMapper.contractorToContractorDto(contractorFromDb);
    }

    @Override
    public ContractorDTO findById(UUID id) {
        return contractorMapper.contractorToContractorDto(
                contractorRepository.findById(id)
                        .orElseThrow(ContractorNotFoundException::new)
        );
    }

    @Override
    public List<ContractorDTO> findAll() {
        return contractorRepository
                .findAll()
                .stream()
                .map(contractorMapper::contractorToContractorDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (contractorRepository.existsById(id)) {
            contractorRepository.deleteById(id);
        } else {
            throw new ContractorNotFoundException();
        }
    }
}
