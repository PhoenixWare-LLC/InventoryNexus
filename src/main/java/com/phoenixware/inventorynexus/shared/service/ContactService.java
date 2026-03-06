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
    ContactDTO createContact(ContactDTO contactDTO);
    ContactDTO getContactById(UUID id);
    List<ContactDTO> findAll();
}
