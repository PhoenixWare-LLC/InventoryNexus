package com.phoenixware.inventorynexus.shared.controller;

import com.phoenixware.inventorynexus.shared.dto.AppUserDTO;
import com.phoenixware.inventorynexus.shared.service.AppUserService;
import com.phoenixware.inventorynexus.shared.util.CurrentUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final CurrentUserService currentUserService;
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/users")
    public ResponseEntity<String> registerUser(@RequestBody AppUserDTO appUserDTO) {
        try {
            appUserDTO.setPassword(passwordEncoder.encode(appUserDTO.getPassword()));

            appUserDTO.setId(null);
            AppUserDTO registeredUser = appUserService.createAppUser(appUserDTO);


            if (registeredUser == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User creation failed");
            } else {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Location", "/users/" + registeredUser.getId());

                ResponseEntity responseEntity = new ResponseEntity(
                        "User Created Successfully",
                        headers,
                        HttpStatus.CREATED
                );

                return responseEntity;
            }
        } catch (Exception e) {
            log.error("Failed to register user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred while creating the user.");
        }
    }

    @GetMapping("/users/whoami")
    public String whoAmI() {
        return currentUserService.getCurrentUser().getUsername();
    }
}
