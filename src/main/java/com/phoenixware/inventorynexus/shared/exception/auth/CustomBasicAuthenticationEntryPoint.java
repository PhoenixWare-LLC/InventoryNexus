package com.phoenixware.inventorynexus.shared.exception.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/24/26
 */
public class CustomBasicAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * @param request       that resulted in an <code>AuthenticationException</code>
     * @param response      so that the user agent can begin authentication
     * @param authException that caused the invocation
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        LocalDateTime currentTimestamp = LocalDateTime.now();
        String message = (authException != null && authException.getMessage() != null) ? authException.getMessage() : "Unauthorized";
        response.setHeader("inventorynexus-error-reason", "Authentication failed");
        String path = request.getRequestURI();
        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        response.setContentType("application/json;charset=UTF-8");
        String jsonResponse =
                String.format(
                        "{\"timestamp\": \"%s\", \"status\": %d, \"error\": \"%s\", \"message\": \"%s\", \"path\": \"%s\"}",
                        currentTimestamp,
                        HttpStatus.UNAUTHORIZED.value(),
                        HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                        message,
                        path
                );
        response.getWriter().write(jsonResponse);
    }
}
