package com.phoenixware.inventorynexus.shared.controller;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;
import com.phoenixware.inventorynexus.shared.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RequiredArgsConstructor
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contacts/{contactId}")
    public ResponseEntity contactForm(@PathVariable("contactId") UUID id) {
        ContactDTO contactDTO = contactService.getContactById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/contacts/" + contactDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity<>(
                contactDTO,
                httpHeaders,
                HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping("/contacts")
    public ResponseEntity getAllContacts() {
        List<ContactDTO> contactDTOS = contactService.findAll();

        ResponseEntity responseEntity = new ResponseEntity(
                contactDTOS,
                HttpStatus.OK
        );

        return responseEntity;
    }

    @PostMapping("/contacts")
    public ResponseEntity createContact(@RequestBody ContactDTO contactDTO) {
        ContactDTO savedContact = contactService.createContact(contactDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/contacts/" + savedContact.getId());

        ResponseEntity responseEntity = new ResponseEntity<>(
                savedContact,
                httpHeaders,
                HttpStatus.CREATED.value()
        );

        return responseEntity;
    }

}
