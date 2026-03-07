package com.phoenixware.inventorynexus.shared.dto.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class RoleDetailedDTO {
    private UUID id;
    private String name;
}
