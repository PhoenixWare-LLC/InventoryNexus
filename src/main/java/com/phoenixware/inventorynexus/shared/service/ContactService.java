package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
public interface ContactService {
    ContactDTO create(ContactDTO contactDTO);
    ContactDTO updateById(UUID id, ContactDTO contactDTO);
    ContactDTO patchById(UUID id, ContactDTO contactDTO);
    ContactDTO findById(UUID id);
    List<ContactDTO> findAll();
    void deleteById(UUID id);
}
