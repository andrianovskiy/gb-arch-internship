package com.arch.intern.crm.backend.common.abstractmodel;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
public class AbstractDTO implements Serializable {
    private Long id;
    private String name;
}
