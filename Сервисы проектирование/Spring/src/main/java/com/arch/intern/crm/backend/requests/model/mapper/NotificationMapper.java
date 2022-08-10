package com.arch.intern.crm.backend.requests.model.mapper;


import com.arch.intern.crm.backend.notification.model.Notification;
import com.arch.intern.crm.backend.notification.model.dto.NotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Mapper
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    NotificationDTO toDTO(Notification item);

    List<NotificationDTO> toDTOList(List<Notification> itemList);

}

