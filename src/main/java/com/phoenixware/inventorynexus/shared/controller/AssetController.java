package com.phoenixware.inventorynexus.shared.controller;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;
import com.phoenixware.inventorynexus.shared.dto.asset.AssetWithDataDTO;
import com.phoenixware.inventorynexus.shared.service.AssetService;
import com.phoenixware.inventorynexus.shared.validation.Create;
import com.phoenixware.inventorynexus.shared.validation.Patch;
import com.phoenixware.inventorynexus.shared.validation.Update;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
@RestController
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;

    @GetMapping("/assets/{id}")
    public ResponseEntity<AssetWithDataDTO> getAsset(
            @PathVariable("id")
            UUID id
    ) {
        AssetWithDataDTO assetWithDataDTO = assetService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + assetWithDataDTO.getId());

        ResponseEntity<AssetWithDataDTO> responseEntity = new ResponseEntity<>(
                assetWithDataDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/assets/{id}")
    public ResponseEntity<AssetWithDataDTO> putAsset(
            @PathVariable("id")
            UUID id,
            @RequestPart("file")
            MultipartFile multipartFile,
            @RequestPart("data") @Validated(Update.class)
            AssetDTO assetDTO
    ) {
        AssetWithDataDTO updatedAssetWithDataDto = assetService.updateById(id, assetDTO, multipartFile);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + updatedAssetWithDataDto.getId());

        ResponseEntity<AssetWithDataDTO> responseEntity = new ResponseEntity<>(
                updatedAssetWithDataDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/assets/{id}")
    public ResponseEntity<AssetWithDataDTO> patchAsset(
            @PathVariable("id")
            UUID id,
            @RequestPart("file")
            MultipartFile multipartFile,
            @RequestPart("data") @Validated(Patch.class)
            AssetDTO assetDTO) {
        AssetWithDataDTO patchedAssetWithDataDto = assetService.patchById(id, assetDTO, multipartFile);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + patchedAssetWithDataDto);

        ResponseEntity<AssetWithDataDTO> responseEntity = new ResponseEntity<>(
                patchedAssetWithDataDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PostMapping("/assets")
    public ResponseEntity<AssetWithDataDTO> postAsset(
            @RequestPart("file") @NotNull
            MultipartFile multipartFile,
            @RequestPart("data") @Validated(Create.class)
            AssetDTO assetDTO
    ) {
        AssetWithDataDTO postedAssetWithDataDto = assetService.create(assetDTO, multipartFile);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + postedAssetWithDataDto.getId());

        ResponseEntity<AssetWithDataDTO> responseEntity = new ResponseEntity<>(
                postedAssetWithDataDto,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/assets/{id}")
    public ResponseEntity<AssetWithDataDTO> deleteAsset(
            @PathVariable("id")
            UUID id
    ) {
        assetService.deleteById(id);

        ResponseEntity<AssetWithDataDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
