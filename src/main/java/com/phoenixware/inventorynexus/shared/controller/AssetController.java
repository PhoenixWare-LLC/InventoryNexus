package com.phoenixware.inventorynexus.shared.controller;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;
import com.phoenixware.inventorynexus.shared.service.AssetService;
import com.phoenixware.inventorynexus.shared.validation.Create;
import com.phoenixware.inventorynexus.shared.validation.Patch;
import com.phoenixware.inventorynexus.shared.validation.Update;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AssetDTO> getBinLocation(
            @PathVariable("id")
            UUID id
    ) {
        AssetDTO assetDTO = assetService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + assetDTO.getId());

        ResponseEntity<AssetDTO> responseEntity = new ResponseEntity<>(
                assetDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/assets/{id}")
    public ResponseEntity<AssetDTO> putBinLocation(
            @PathParam("id")
            UUID id,
            @RequestBody @Validated(Update.class)
            AssetDTO assetDTO
    ) {
        AssetDTO updatedAssetDto = assetService.updateById(id, assetDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + updatedAssetDto.getId());

        ResponseEntity<AssetDTO> responseEntity = new ResponseEntity<>(
                updatedAssetDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/assets/{id}")
    public ResponseEntity<AssetDTO> patchBinLocation(
            @PathParam("id")
            UUID id,
            @RequestBody @Validated(Patch.class)
            AssetDTO assetDTO) {
        AssetDTO patchedAssetDto = assetService.patchById(id, assetDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + patchedAssetDto);

        ResponseEntity<AssetDTO> responseEntity = new ResponseEntity<>(
                patchedAssetDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PostMapping("/assets/")
    public ResponseEntity<AssetDTO> postBinLocation(
            @RequestBody @Validated(Create.class)
            AssetDTO assetDTO
    ) {
        AssetDTO postedAssetDto = assetService.create(assetDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/assets/" + postedAssetDto.getId());

        ResponseEntity<AssetDTO> responseEntity = new ResponseEntity<>(
                postedAssetDto,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/assets/{id}")
    public ResponseEntity<AssetDTO> deleteBinLocation(
            @PathVariable("id")
            UUID id
    ) {
        assetService.deleteById(id);

        ResponseEntity<AssetDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
