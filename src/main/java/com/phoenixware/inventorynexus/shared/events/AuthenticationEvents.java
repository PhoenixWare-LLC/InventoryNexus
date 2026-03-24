package com.phoenixware.inventorynexus.shared.events;

import com.phoenixware.inventorynexus.shared.service.LoginAttemptService;
import com.phoenixware.inventorynexus.shared.util.IpUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/25/2026
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthenticationEvents {
    private final LoginAttemptService loginAttemptService;
    private final IpUtils ipUtils;


    @EventListener
    public void onSuccess(AuthenticationSuccessEvent authenticationSuccessEvent) {
        String username = authenticationSuccessEvent.getAuthentication().getName();
        String ip = ipUtils.getClientIP(getCurrentRequest());

        loginAttemptService.reset(ip, username);
        log.info("Login successful for the user : {}", authenticationSuccessEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
        String username = authenticationFailureBadCredentialsEvent.getAuthentication().getName();
        String ip = ipUtils.getClientIP(getCurrentRequest());

        loginAttemptService.recordFailedAttempt(ip, username);
        log.error("Login failed for the user : {} with ip : {} due to : {}",
                username,
                ip,
                authenticationFailureBadCredentialsEvent.getException().getMessage()
        );
    }

    private HttpServletRequest getCurrentRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getRequest();
    }
}
