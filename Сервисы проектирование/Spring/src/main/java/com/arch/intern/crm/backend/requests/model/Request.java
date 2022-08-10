package com.arch.intern.crm.backend.requests.model;

import com.arch.intern.crm.backend.client.model.ContractorAddress;
import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.requests.model.enums.Resolution;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "requests")
public class Request extends AbstractEntity {

 private String number;

 @ManyToOne
 @JoinColumn(name = "contractor_id")
 private Contractor contractor;

 @ManyToOne
 @JoinColumn(name = "contractor_address_id")
 private ContractorAddress contractorAddress;

 @ManyToOne
 @JoinColumn(name = "request_status_id")
 private RequestStatus requestStatus;

 @Enumerated(EnumType.STRING)
 private Resolution resolution;

 @ManyToOne
 @JoinColumn(name = "request_type_id")
 private RequestType requestType;

}
