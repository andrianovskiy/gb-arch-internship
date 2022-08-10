package com.arch.intern.crm.backend.order.exception;

import java.text.MessageFormat;


/**
 * @author Marchenko_DS in 25/04/2022
 */
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(final Long id){
        super(MessageFormat.format("Could not find item with id: {0}", id));
    }
}
