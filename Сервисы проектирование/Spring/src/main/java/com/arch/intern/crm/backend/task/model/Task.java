package com.arch.intern.crm.backend.task.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.notification.model.Notification;
import com.arch.intern.crm.backend.requests.model.Request;
import com.arch.intern.crm.backend.task.model.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Entity
@Table(name = "tasks")
@Data
@EqualsAndHashCode
public class Task extends AbstractEntity {

    @ManyToOne
    private Request request;

    private String title;

    private String text;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @OneToMany
    private List<Notification> messages;

    @Column(name = "close")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date close;
}
