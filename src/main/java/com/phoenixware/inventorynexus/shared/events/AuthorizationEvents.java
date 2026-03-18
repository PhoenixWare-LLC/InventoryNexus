package com.phoenixware.inventorynexus.shared.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/25/2026
 */
@Component
@Slf4j
public class AuthorizationEvents {

    @EventListener
    public void onFailure(AuthorizationDeniedEvent authorizationDeniedEvent) {
        log.error("Authorization Failed for the user : {} due to : {}",
                authorizationDeniedEvent.getAuthentication().get().getName(),
                authorizationDeniedEvent.getAuthorizationResult().toString()
        );
    }
}
