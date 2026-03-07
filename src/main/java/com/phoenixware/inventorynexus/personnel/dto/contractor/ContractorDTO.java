package com.phoenixware.inventorynexus.personnel.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractorDTO {
    private UUID id;
}
