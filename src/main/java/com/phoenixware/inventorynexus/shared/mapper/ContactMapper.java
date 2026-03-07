package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.contact.ContactDTO;
import com.phoenixware.inventorynexus.shared.entity.Contact;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/4/2026
 */
@Mapper
public interface ContactMapper {
    Contact contactDtoToContact(ContactDTO contactDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Contact patchContactFromContactDto(ContactDTO contactDTO, @MappingTarget Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ContactDTO patchContactDtoFromContact(Contact contact, @MappingTarget ContactDTO contactDTO);

    ContactDTO contactToContactDto(Contact contact);
}
