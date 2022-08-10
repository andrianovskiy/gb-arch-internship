package com.arch.intern.crm.backend.order.controller;

import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.order.model.Order;
import com.arch.intern.crm.backend.order.model.dto.CartDto;
import com.arch.intern.crm.backend.order.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@RestController
@RequestMapping("/carts")
@Tag(name = "Заказы по клиенту")
public class CartController implements BaseController<CartDto> {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    @PostMapping
    public ResponseEntity<CartDto> add(@RequestBody final CartDto cartDto){
        Order cart = cartService.save(Order.from(cartDto));
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CartDto>> getAll(){
        List<Order> carts = cartService.findAll();
        List<CartDto> cartsDto = carts.stream().map(CartDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(cartsDto, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "{id}")
    public ResponseEntity<CartDto> get(@PathVariable final Long id){
        Order cart = cartService.getCart(id);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<CartDto> delete(@PathVariable final Long id){
        Order cart = cartService.delete(id);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "{id}")
    public ResponseEntity<CartDto> edit(@PathVariable final Long id,
                                            @RequestBody final CartDto cartDto){
        Order cart = cartService.editCart(id, Order.from(cartDto));
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }


}
