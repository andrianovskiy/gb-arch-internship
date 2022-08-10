package com.arch.intern.crm.backend.task.model.dto;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import com.arch.intern.crm.backend.notification.model.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
@EqualsAndHashCode
public class TaskDTO extends AbstractDTO{

    private String title;
    private String text;
    private List<Notification> messages;

}
