package com.phoenixware.inventorynexus.shared.dto.contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private UUID id;
    private String name;
    private String email;
    private String subject;
    private String body;
}
