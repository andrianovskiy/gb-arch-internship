package com.arch.intern.crm.backend.client.model.mapper;


import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import com.arch.intern.crm.backend.client.model.contractor.Person;
import com.arch.intern.crm.backend.client.model.dto.OrgatizationDTO;
import com.arch.intern.crm.backend.client.model.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Marchenko_DS in 25/04/2022
 */
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDTO(Person item);

    List<PersonDTO> toDTOList(List<Person> itemList);

}

