package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;
import com.phoenixware.inventorynexus.shared.repository.ContactRepository;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
public interface ContactService {
    ContactDTO createContact(ContactDTO contactDTO);
}
