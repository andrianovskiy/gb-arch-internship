package com.arch.intern.crm.backend.order.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.order.model.dto.OrderItemDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Entity
@Data
@Table(name = "order_items")
public class OrderItem extends AbstractEntity {

    private Double qty;

    private Double price;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    public static OrderItem from(OrderItemDto itemDto){
        OrderItem item = new OrderItem();
        item.setQty(itemDto.getQty());
        return item;
    }

}
