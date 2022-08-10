package com.arch.intern.crm.backend.client.model.mapper;


import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import com.arch.intern.crm.backend.client.model.contractor.Organization;
import com.arch.intern.crm.backend.client.model.dto.OrgatizationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Marchenko_DS in 25/04/2022
 */
@Mapper
public interface OrganizationMapper {

    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    OrgatizationDTO toDTO(Organization item);

    List<OrgatizationDTO> toDTOList(List<Organization> itemList);

}

