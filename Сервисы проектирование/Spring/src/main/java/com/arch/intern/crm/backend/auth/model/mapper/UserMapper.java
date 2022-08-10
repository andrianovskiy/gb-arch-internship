package com.arch.intern.crm.backend.auth.model.mapper;


import com.arch.intern.crm.backend.auth.model.User;
import com.arch.intern.crm.backend.auth.model.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Marchenko_DS in 25/04/2022 - 17:51
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User item);

    List<UserDTO> toDTOList(List<User> itemList);

}

