package com.phoenixware.inventorynexus.shared.dto.appuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {
    private UUID id;
    private String email;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean active = false;
    private boolean admin = false;
    private String mfaType = "email";
    private LocalDateTime createdAt;
    private String createdBy;
}
