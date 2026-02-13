package com.phoenixware.inventorynexus.shared.util;

import com.phoenixware.inventorynexus.shared.config.AppUserDetails;
import com.phoenixware.inventorynexus.shared.entity.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
@Service
public class CurrentUserService {

    public AppUser getCurrentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        Object principal = auth.getPrincipal();
        if (principal instanceof AppUserDetails userDetails) {
            return userDetails.getAppUser();
        }
        return null;
    }
}
