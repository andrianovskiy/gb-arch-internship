package com.arch.intern.crm.backend.client.model.contractor;

import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@Data
@DiscriminatorValue("ORGANIZATION")
public class Organization extends Contractor {

    private String name;

    private String shortName;

    private Integer inn;

    private Integer kpp;

    private Integer ogrn;


}
