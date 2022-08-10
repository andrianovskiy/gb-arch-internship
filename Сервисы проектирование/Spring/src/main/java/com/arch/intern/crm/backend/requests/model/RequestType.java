package com.arch.intern.crm.backend.requests.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.task.model.WorkFlow;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "request_type")
public class RequestType extends AbstractEntity {

 private String name;


 @ManyToOne
 @JoinColumn(name = "request_type_id")
 private RequestType requestType;

 @ManyToOne
 private WorkFlow workFlow;

 private boolean archive;

}
