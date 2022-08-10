package com.arch.intern.crm.backend.client.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "phones")
@Data
public class Phone extends AbstractEntity {

    private String code;
    private String text;

    private boolean active;
}
