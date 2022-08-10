package com.arch.intern.crm.backend.order.model.dto;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import com.arch.intern.crm.backend.order.model.OrderItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Data
@EqualsAndHashCode
public class OrderItemDto extends AbstractDTO {

    private Double qty;
    private PlainCartDto plainCartDto;

    public static OrderItemDto from(OrderItem item){
        OrderItemDto itemDto = new OrderItemDto();
        itemDto.setId(item.getId());
        itemDto.setQty(item.getQty());
        if(Objects.nonNull(item.getOrder())){
            itemDto.setPlainCartDto(PlainCartDto.from(item.getOrder()));
        }
        return itemDto;
    }


}
