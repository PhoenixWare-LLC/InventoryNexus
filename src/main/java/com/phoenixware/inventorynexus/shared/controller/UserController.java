package com.phoenixware.inventorynexus.shared.controller;

import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDTO;
import com.phoenixware.inventorynexus.shared.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final AppUserService appUserService;

    @GetMapping("/user")
    public AppUserDTO getUserAfterAuthentication(Authentication authentication) {
        return appUserService.findByUsername(authentication.getName());
    }
}
