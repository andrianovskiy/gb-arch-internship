package com.arch.intern.crm.backend.client.model.contractor;

import com.arch.intern.crm.backend.client.model.ContractorAddress;
import com.arch.intern.crm.backend.client.model.ContractorType;
import com.arch.intern.crm.backend.client.model.Email;
import com.arch.intern.crm.backend.client.model.Phone;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "contractors")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CONTRACTOR")
@Data
@ToString
public class Contractor extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private ContractorType type = ContractorType.PERSON;

    @OneToMany
    private List<Email> email;

    @OneToMany
    private List<Phone> phones;


    private List<ContractorAddress> contractorAddress;

}
