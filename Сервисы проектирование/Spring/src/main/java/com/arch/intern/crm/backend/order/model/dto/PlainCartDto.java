package com.arch.intern.crm.backend.order.model.dto;

import com.arch.intern.crm.backend.order.model.Order;
import lombok.Data;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Data
public class PlainCartDto {
    private Long id;
    private String name;

    public static PlainCartDto from(Order cart){
        PlainCartDto plainCartDto = new PlainCartDto();
        plainCartDto.setId(cart.getId());
        plainCartDto.setName(cart.getName());
        return plainCartDto;
    }
}
