package com.arch.intern.crm.backend.client.model.dto;

import com.arch.intern.crm.backend.client.model.ContractorAddress;
import com.arch.intern.crm.backend.client.model.ContractorType;
import com.arch.intern.crm.backend.client.model.Email;
import com.arch.intern.crm.backend.client.model.Phone;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
public class PersonDTO extends AbstractDTO {

    private ContractorType type = ContractorType.PERSON;

    private List<Email> email;

    private List<Phone> phones;

    private List<ContractorAddress> contractorAddress;


}
