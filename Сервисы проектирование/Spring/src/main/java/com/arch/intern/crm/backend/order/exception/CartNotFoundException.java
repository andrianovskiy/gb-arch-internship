package com.arch.intern.crm.backend.order.exception;

import java.text.MessageFormat;


/**
 * @author Marchenko_DS in 25/04/2022
 */
public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }

}
