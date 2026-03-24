package com.phoenixware.inventorynexus.shared.filter;


import com.phoenixware.inventorynexus.shared.util.IpUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/20/2026
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RequestValidationAfterFilter implements Filter {

    private final IpUtils ipUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            log.info("User " + authentication.getName() + " is successfully authenticated and "
            + "has the authorities" + authentication.getAuthorities().toString() + " from IP: " + ipUtils.getClientIP((HttpServletRequest) servletRequest));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
