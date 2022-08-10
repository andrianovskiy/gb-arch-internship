package com.arch.intern.crm.backend.order.model.dto;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import com.arch.intern.crm.backend.order.model.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Data
public class CartDto extends AbstractDTO {

    private List<OrderItemDto> itemsDto = new ArrayList<>();

    public static CartDto from(Order cart){
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
      //  cartDto.setName(cart.getName());
        cartDto.setItemsDto(cart.getItems().stream().map(OrderItemDto::from).collect(Collectors.toList()));
        return cartDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartDto)) return false;
        if (!super.equals(o)) return false;
        CartDto cartDto = (CartDto) o;
        return Objects.equals(itemsDto, cartDto.itemsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), itemsDto);
    }
}
