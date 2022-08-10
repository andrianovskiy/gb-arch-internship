package com.arch.intern.crm.backend.notification.model;

import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Entity
@Table(name = "notifications")
@Data
@EqualsAndHashCode
public class Notification extends AbstractEntity {

    private String title;

    private String text;

    @OneToOne
    private Contractor contractor;
}
