package com.arch.intern.crm.backend.order.service;

import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.order.repository.OrderRepository;
import com.arch.intern.crm.backend.order.model.Order;
import com.arch.intern.crm.backend.order.model.OrderItem;
import com.arch.intern.crm.backend.order.exception.CartNotFoundException;
import com.arch.intern.crm.backend.order.exception.ItemIsAlreadyAssignedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class CartService implements CrudService<Order> {

    private final OrderRepository cartRepository;
    private final ItemService itemService;

    @Autowired
    public CartService(OrderRepository cartRepository, ItemService itemService) {
        this.cartRepository = cartRepository;
        this.itemService = itemService;
    }

    @Override
    public JpaRepository<Order, Long> getRepository() {
        return cartRepository;
    }

    /**
     *
     * @param id
     * @return
     */
    public Order getCart(Long id) {
        return find(id).orElseThrow(() ->
                new CartNotFoundException(id));
    }

    /**
     *
     * @param id
     * @param cart
     * @return
     */
    @Transactional
    public Order editCart(Long id, Order cart) {
        Order cartToEdit = getCart(id);
        cartToEdit.setName(cart.getName());
        return cartToEdit;
    }

    /**
     *
     * @param cartId
     * @param itemId
     * @return
     */
    @Transactional
    public Order addItemToCart(Long cartId, Long itemId) {
        Order cart = getCart(cartId);
        OrderItem item = itemService.getItem(itemId);
        if (Objects.nonNull(item.getOrder())) {
            throw new ItemIsAlreadyAssignedException(itemId,
                    item.getOrder().getId());
        }
        cart.addItem(item);
        item.setOrder(cart);
        return cart;
    }

    /**
     *
     * @param cartId
     * @param itemId
     * @return
     */
    @Transactional
    public Order removeItemFromCart(Long cartId, Long itemId) {
        Order cart = getCart(cartId);
        OrderItem item = itemService.getItem(itemId);
        cart.removeItem(item);
        return cart;
    }

}
