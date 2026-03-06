package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;
import com.phoenixware.inventorynexus.shared.mapper.ContactMapper;
import com.phoenixware.inventorynexus.shared.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        return contactMapper.contactToContactDto(contactRepository.save(contactMapper.contactDtoToContact(contactDTO)));
    }


}
