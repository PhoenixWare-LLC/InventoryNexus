package com.phoenixware.inventorynexus.shared.controller;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;
import com.phoenixware.inventorynexus.shared.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RequiredArgsConstructor
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contacts")
    public String contactForm() {
        return "This will be the page where the form of contact will come into play.. yay.";
    }

    @PostMapping("/contacts")
    public ResponseEntity createContact(@RequestBody ContactDTO contactDTO) {
        ContactDTO savedContact = contactService.createContact(contactDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/contact/" + savedContact.getId());

        ResponseEntity responseEntity = new ResponseEntity<>(
                savedContact,
                httpHeaders,
                HttpStatus.CREATED.value()
        );

        return responseEntity;
    }

}
