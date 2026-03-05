package com.phoenixware.inventorynexus.shared.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {
        LocalDateTime currentTimestamp = LocalDateTime.now();
        String message = (accessDeniedException != null && accessDeniedException.getMessage() != null) ? accessDeniedException.getMessage() : "Authorization failed";
        response.setHeader("inventorynexus-denied-reason", "Authorization failed");
        String path = request.getRequestURI();
        response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        response.setContentType("application/json;charset=UTF-8");
        String jsonResponse =
                String.format(
                        "{\"timestamp\": \"%s\", \"status\": %d, \"error\": \"%s\", \"message\": \"%s\", \"path\": \"%s\"}",
                        currentTimestamp,
                        HttpStatus.FORBIDDEN.value(),
                        HttpStatus.FORBIDDEN.getReasonPhrase(),
                        message,
                        path
                );
        response.getWriter().write(jsonResponse);
    }
}
