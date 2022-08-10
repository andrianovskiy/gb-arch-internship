package com.arch.intern.crm.backend.client.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity(name = "contractor_address")
@Data
public class ContractorAddress extends AbstractEntity {

    private String description;

    private String address;

    private String fias;

    private String phone;

    private String contactPersone;

}
