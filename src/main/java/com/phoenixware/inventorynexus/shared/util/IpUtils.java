package com.phoenixware.inventorynexus.shared.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/23/2026
 */
@Component
public class IpUtils {
    private static final String[] IP_HEADERS = {
            "X-Forwarded-For",
            "X-Real-IP",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_CLIENT_IP",
            "HTTP_X_FORWARDED_FOR"
    };

    public String getClientIP(HttpServletRequest httpServletRequest) {
        if (httpServletRequest == null) {
            return "0.0.0.0";
        }
        for (String header : IP_HEADERS) {
            String ip = httpServletRequest.getHeader(header);
            if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
                return ip.split(",")[0].trim();
            }
        }

        return httpServletRequest.getRemoteAddr();
    }
}
