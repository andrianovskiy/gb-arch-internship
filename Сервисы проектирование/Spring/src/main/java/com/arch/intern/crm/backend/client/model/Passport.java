package com.arch.intern.crm.backend.client.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@Entity(name = "passport")
@Data
public class Passport extends AbstractEntity {

    private String type;

    private String serial;

    private String number;

    private LocalDate issueDate;

    private String issuer;

    private boolean active;
}
