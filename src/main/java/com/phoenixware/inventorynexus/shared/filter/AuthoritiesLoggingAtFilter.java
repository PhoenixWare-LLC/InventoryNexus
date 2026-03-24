package com.phoenixware.inventorynexus.shared.filter;

import com.phoenixware.inventorynexus.shared.util.IpUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/23/2026
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AuthoritiesLoggingAtFilter implements Filter {

    private final IpUtils ipUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Authentication Validation is in progress from IP: " + ipUtils.getClientIP((HttpServletRequest) servletRequest));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
