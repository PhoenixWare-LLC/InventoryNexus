package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;
import com.phoenixware.inventorynexus.shared.entity.Contact;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
@Mapper
public interface ContactMapper {
    Contact contactDtoToContact(ContactDTO contactDTO);

    ContactDTO contactToContactDto(Contact contact);
}
