package com.phoenixware.inventorynexus.inventory.controller;

import com.phoenixware.inventorynexus.inventory.dto.binlocation.BinLocationDTO;
import com.phoenixware.inventorynexus.inventory.service.BinLocationService;
import com.phoenixware.inventorynexus.shared.validation.Create;
import com.phoenixware.inventorynexus.shared.validation.Patch;
import com.phoenixware.inventorynexus.shared.validation.Update;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RestController
@RequiredArgsConstructor
public class BinLocationController {
    private final BinLocationService binLocationService;

    @GetMapping("/bin-locations/{id}")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'bin-locations', 'read')")
    public ResponseEntity<BinLocationDTO> getBinLocation(
            @PathVariable("id")
            UUID id
    ) {
        BinLocationDTO binLocationDTO = binLocationService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + binLocationDTO.getId());

        ResponseEntity<BinLocationDTO> responseEntity = new ResponseEntity<>(
                binLocationDTO,
                httpHeaders,
                HttpStatus.OK
        );

        return responseEntity;
    }

    @PutMapping("/bin-locations/{id}")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'bin-locations', 'update')")
    public ResponseEntity<BinLocationDTO> putBinLocation(
            @PathParam("id")
            UUID id,
            @RequestBody @Validated(Update.class)
            BinLocationDTO binLocationDTO
    ) {
        BinLocationDTO updatedBinLocationDto = binLocationService.updateById(id, binLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + updatedBinLocationDto.getId());

        ResponseEntity<BinLocationDTO> responseEntity = new ResponseEntity<>(
                updatedBinLocationDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/bin-locations/{id}")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'bin-locations', 'update')")
    public ResponseEntity<BinLocationDTO> patchBinLocation(
            @PathParam("id")
            UUID id,
            @RequestBody @Validated(Patch.class)
            BinLocationDTO binLocationDTO) {
        BinLocationDTO patchedBinLocationDto = binLocationService.patchById(id, binLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + patchedBinLocationDto);

        ResponseEntity<BinLocationDTO> responseEntity = new ResponseEntity<>(
                patchedBinLocationDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PostMapping("/bin-locations/")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'bin-locations', 'create')")
    public ResponseEntity<BinLocationDTO> postBinLocation(
            @RequestBody @Validated(Create.class)
            BinLocationDTO binLocationDTO
    ) {
        BinLocationDTO postedBinLocationDto = binLocationService.create(binLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + postedBinLocationDto.getId());

        ResponseEntity<BinLocationDTO> responseEntity = new ResponseEntity<>(
                postedBinLocationDto,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/bin-locations/{id}")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'bin-locations', 'delete')")
    public ResponseEntity<BinLocationDTO> deleteBinLocation(
            @PathVariable("id")
            UUID id
    ) {
        binLocationService.deleteById(id);

        ResponseEntity<BinLocationDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
