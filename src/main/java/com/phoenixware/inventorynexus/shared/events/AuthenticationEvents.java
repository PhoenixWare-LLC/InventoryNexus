package com.phoenixware.inventorynexus.shared.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/25/2026
 */
@Component
@Slf4j
public class AuthenticationEvents {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent authenticationSuccessEvent) {
        log.info("Login successful for the user : {}", authenticationSuccessEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent abstractAuthenticationFailureEvent) {
        log.error("Login failed for the user : {} due to : {}",
                abstractAuthenticationFailureEvent.getAuthentication().getName(),
                abstractAuthenticationFailureEvent.getException().getMessage()
        );
    }
}
