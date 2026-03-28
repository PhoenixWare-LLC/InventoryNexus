package com.phoenixware.inventorynexus.shared.components;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/27/2026
 */
@Component("method_authorization")
public class MethodAuthorizationComponent {

    public boolean hasPrivilege(Authentication authentication, String resource, String action) {
        //TODO: re-implement with new keycloak authorization server
        return false;
    }
}
