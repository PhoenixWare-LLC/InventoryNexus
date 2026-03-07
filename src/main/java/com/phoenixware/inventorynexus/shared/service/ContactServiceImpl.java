package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;
import com.phoenixware.inventorynexus.shared.entity.Contact;
import com.phoenixware.inventorynexus.shared.exception.contact.ContactNotFoundException;
import com.phoenixware.inventorynexus.shared.mapper.ContactMapper;
import com.phoenixware.inventorynexus.shared.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public ContactDTO create(ContactDTO contactDTO) {
        return contactMapper.contactToContactDto(contactRepository.save(contactMapper.contactDtoToContact(contactDTO)));
    }

    @Override
    public ContactDTO updateById(UUID id, ContactDTO contactDTO) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(ContactNotFoundException::new);

        Contact updatedContact = contactMapper.contactDtoToContact(contactDTO);
        updatedContact.setId(id);

        contactRepository.save(updatedContact);

        Contact contactFromDb = contactRepository.findById(id)
                .orElseThrow(ContactNotFoundException::new);

        return contactMapper.contactToContactDto(contactFromDb);
    }

    @Override
    public ContactDTO patchById(UUID id, ContactDTO contactDTO) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(ContactNotFoundException::new);

        Contact patchedContact = contactMapper.patchContactFromContactDto(contactDTO, existingContact);

        contactRepository.save(patchedContact);

        Contact contactFromDb = contactRepository.findById(id)
                .orElseThrow(ContactNotFoundException::new);

        return contactMapper.contactToContactDto(contactFromDb);
    }

    @Override
    public ContactDTO findById(UUID id) {
        return contactMapper.contactToContactDto(contactRepository.findById(id).orElseThrow(ContactNotFoundException::new));
    }

    @Override
    public List<ContactDTO> findAll() {
        return  contactRepository
                .findAll()
                .stream()
                .map(contactMapper::contactToContactDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
        } else {
            throw new ContactNotFoundException();
        }

    }


}
