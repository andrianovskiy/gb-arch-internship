package com.arch.intern.crm.backend.requests.model.dto;

import com.arch.intern.crm.backend.client.model.ContractorAddress;
import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import com.arch.intern.crm.backend.requests.model.RequestStatus;
import com.arch.intern.crm.backend.requests.model.RequestType;
import com.arch.intern.crm.backend.requests.model.enums.Resolution;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
public class RequestDTO extends AbstractDTO{

    private String number;

    private Contractor contractor;

    private ContractorAddress contractorAddress;

    private RequestStatus requestStatus;

    private Resolution resolution;

    private RequestType requestType;

}
