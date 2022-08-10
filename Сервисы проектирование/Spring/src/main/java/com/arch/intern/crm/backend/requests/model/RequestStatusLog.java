package com.arch.intern.crm.backend.requests.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.requests.model.Request;
import com.arch.intern.crm.backend.requests.model.RequestStatus;
import com.arch.intern.crm.backend.requests.model.enums.RequestStatusType;
import com.arch.intern.crm.backend.requests.model.enums.Resolution;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "request_status_log")
public class RequestStatusLog extends AbstractEntity {

    @ManyToOne
    private Request request;

    @ManyToOne
    private RequestStatus requestStatus;


    @Enumerated(EnumType.STRING)
    private Resolution resolution;

    private LocalDate localDate;

    private String comment;
}
