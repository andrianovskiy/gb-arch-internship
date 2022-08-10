package com.arch.intern.crm.backend.requests.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.requests.model.enums.RequestStatusType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "request_statuses")
public class RequestStatus extends AbstractEntity {

 private String name;


 @Enumerated(EnumType.STRING)
 private RequestStatusType requestStatusType;

}
