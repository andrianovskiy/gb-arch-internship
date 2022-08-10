package com.arch.intern.crm.backend.order.exception;

import java.text.MessageFormat;


/**
 * @author Marchenko_DS in 25/04/2022
 */
public class ItemIsAlreadyAssignedException extends RuntimeException{
    public ItemIsAlreadyAssignedException(final Long itemId, final Long cartId){
        super(MessageFormat.format("Item: {0} is already assigned to cart: {1}", itemId, cartId));
    }
}
