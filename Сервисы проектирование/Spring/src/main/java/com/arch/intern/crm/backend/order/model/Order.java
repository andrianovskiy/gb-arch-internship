package com.arch.intern.crm.backend.order.model;

import com.arch.intern.crm.backend.client.model.contractor.Contractor;
import com.arch.intern.crm.backend.client.model.ContractorAddress;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.order.model.dto.CartDto;
import com.arch.intern.crm.backend.order.model.enums.OrderStatus;
import com.arch.intern.crm.backend.requests.model.Request;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Data
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    @ManyToOne
    private Contractor contractor;

    @ManyToOne
    private ContractorAddress contractorAddress;

    @ManyToOne
    private Request request;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public static Order from(CartDto cartDto){
        Order cart = new Order();
        cart.setName(cartDto.getName());
        return cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order cart = (Order) o;
        return Objects.equals(name, cart.name) && Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, items);
    }
}
