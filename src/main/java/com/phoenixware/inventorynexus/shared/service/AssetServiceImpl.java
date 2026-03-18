package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;
import com.phoenixware.inventorynexus.shared.dto.asset.AssetWithDataDTO;
import com.phoenixware.inventorynexus.shared.entity.Asset;
import com.phoenixware.inventorynexus.shared.exception.GlobalRestException;
import com.phoenixware.inventorynexus.shared.mapper.AssetMapper;
import com.phoenixware.inventorynexus.shared.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {
    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Override
    public AssetWithDataDTO create(AssetDTO assetDTO, MultipartFile multipartFile) {
        //Validation
        verifyFileType(multipartFile);

        //TODO: add verification here to prevent malicious file uploads

        AssetWithDataDTO assetWithDataDTO = assetMapper.assetDtoToAssetWithDataDto(assetDTO);

        try {
            //TODO: add image compression here.
            assetWithDataDTO.setImageData(multipartFile.getBytes());
            assetWithDataDTO.setSize(multipartFile.getSize());
            assetWithDataDTO.setType(multipartFile.getContentType());
        } catch (Exception exception) {
            throw new GlobalRestException();
        }


        return assetMapper.assetToAssetWithDataDto(assetRepository.save(assetMapper.assetWithDataDtoToAsset(assetWithDataDTO)));
    }

    @Override
    public AssetWithDataDTO updateById(UUID id, AssetDTO assetDTO, MultipartFile multipartFile) {
        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(GlobalRestException::new);

        //Validation
        verifyFileType(multipartFile);

        //TODO: add verification here to prevent malicious file uploads

        AssetWithDataDTO assetWithDataDTO = assetMapper.assetDtoToAssetWithDataDto(assetDTO);
        if (!multipartFile.isEmpty() && multipartFile != null) {
            try {
                //TODO: add image compression here.
                assetWithDataDTO.setImageData(multipartFile.getBytes());
                assetWithDataDTO.setSize(multipartFile.getSize());
                assetWithDataDTO.setType(multipartFile.getContentType());
            } catch (Exception exception) {
                throw new GlobalRestException();
            }
        }
        
        Asset updatedAsset = assetMapper.assetWithDataDtoToAsset(assetWithDataDTO);
        updatedAsset.setId(id);

        assetRepository.save(updatedAsset);

        Asset assetFromDb = assetRepository.findById(id)
                .orElseThrow(GlobalRestException::new);

        return assetMapper.assetToAssetWithDataDto(assetFromDb);
    }

    @Override
    public AssetWithDataDTO patchById(UUID id, AssetDTO assetDTO, MultipartFile multipartFile) {
        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(GlobalRestException::new);

        //Validation
        verifyFileType(multipartFile);

        //TODO: add verification here to prevent malicious file uploads

        AssetWithDataDTO assetWithDataDTO = assetMapper.assetDtoToAssetWithDataDto(assetDTO);
        
        if (!multipartFile.isEmpty() && multipartFile != null) {
            try {
                //TODO: add image compression here.
                assetWithDataDTO.setImageData(multipartFile.getBytes());
                assetWithDataDTO.setSize(multipartFile.getSize());
                assetWithDataDTO.setType(multipartFile.getContentType());
            } catch (Exception exception) {
                throw new GlobalRestException();
            }
        }
        Asset patchedAsset = assetMapper.patchAssetFromAssetWithDataDto(assetWithDataDTO, existingAsset);

        assetRepository.save(patchedAsset);

        Asset assetFromDb = assetRepository.findById(id)
                .orElseThrow(GlobalRestException::new);

        return assetMapper.assetToAssetWithDataDto(assetFromDb);
    }

    private void verifyFileType(MultipartFile multipartFile) {
        String contentType = multipartFile.getContentType();
        if (contentType == null ||
                !(contentType.equals("image/jpeg") ||
                        contentType.equals("image/jpg") ||
                        contentType.equals("image/png") ||
                        contentType.equals("image/svg+xml") ||
                        contentType.equals("application/pdf"))) {
            throw new IllegalArgumentException("Invalid Filetype Detected");
        }
    }

    @Override
    public AssetWithDataDTO findById(UUID id) {
        return assetMapper.assetToAssetWithDataDto(assetRepository.findById(id).orElseThrow(GlobalRestException::new));
    }

    @Override
    public List<AssetWithDataDTO> findAll() {
        return assetRepository
                .findAll()
                .stream()
                .map(assetMapper::assetToAssetWithDataDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (assetRepository.existsById(id)) {
            assetRepository.deleteById(id);
        } else {
            throw new GlobalRestException();
        }

    }
}
