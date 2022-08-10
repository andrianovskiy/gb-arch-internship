package com.arch.intern.crm.backend.notification.model.dto;

import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;

/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
public class NotificationDTO extends AbstractDTO{

    private String title;

    private String text;

    private Contractor contractor;

}
