package com.arch.intern.crm.backend.order.controller;

import com.arch.intern.crm.backend.order.model.Order;
import com.arch.intern.crm.backend.order.model.dto.CartDto;
import com.arch.intern.crm.backend.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author Marchenko_DS in 25/04/2022
 */
public class CartItemController {

    private final CartService cartService;

    @Autowired
    public CartItemController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "{cartId}/items/{itemId}/add")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable final Long cartId,
                                                 @PathVariable final Long itemId){
        Order cart = cartService.addItemToCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @DeleteMapping(value = "{cartId}/items/{itemId}/remove")
    public ResponseEntity<CartDto> removeItemFromCart(@PathVariable final Long cartId,
                                                      @PathVariable final Long itemId){
        Order cart = cartService.removeItemFromCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }
}
