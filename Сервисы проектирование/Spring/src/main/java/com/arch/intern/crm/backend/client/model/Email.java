package com.arch.intern.crm.backend.client.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "emails")
@Data
public class Email extends AbstractEntity {

    private String text;

    private boolean active;
}
