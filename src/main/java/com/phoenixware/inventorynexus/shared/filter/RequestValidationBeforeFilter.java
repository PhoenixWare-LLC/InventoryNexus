package com.phoenixware.inventorynexus.shared.filter;

import com.phoenixware.inventorynexus.shared.service.LoginAttemptService;
import com.phoenixware.inventorynexus.shared.util.IpUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/20/2026
 */
@Component
@RequiredArgsConstructor
public class RequestValidationBeforeFilter implements Filter {

    private final LoginAttemptService loginAttemptService;
    private final IpUtils ipUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);



        if(header != null) {
            header = header.trim();
            if (StringUtils.startsWithIgnoreCase(header, "Basic ")) {
                byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
                byte[] decodedToken;
                try {
                    decodedToken = Base64.getDecoder().decode(base64Token);

                    String token = new String(decodedToken, StandardCharsets.UTF_8); // now we have the Username:Password

                    int delimiter = token.indexOf(":");

                    if(delimiter == -1) {
                        throw new BadCredentialsException("Invalid basic authentication token");
                    }

                    String username = token.substring(0,delimiter);

                    if (username.isEmpty()) {
                        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }

                    String password = token.substring(delimiter);

                    if (password.isEmpty()) {
                        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }

                    if (loginAttemptService.isIpBlocked(ipUtils.getClientIP(httpServletRequest))) {
                        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        return;
                    }

                    if (loginAttemptService.isUsernameBlocked(username)) {
                        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        return;
                    }
                } catch (IllegalArgumentException illegalArgumentException) {
                    throw new BadCredentialsException("Failed to decode basic authentication token");
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
