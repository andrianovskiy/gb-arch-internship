package com.arch.intern.crm.backend.order.controller;

import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.order.model.OrderItem;
import com.arch.intern.crm.backend.order.model.dto.OrderItemDto;
import com.arch.intern.crm.backend.order.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Marchenko_DS in 08/07/2021
 */
@RestController
@RequestMapping("/items")
@Tag(name = "Создание заказа на клиента")
public class ItemController implements BaseController<OrderItemDto> {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    @PostMapping
    public ResponseEntity<OrderItemDto> add(@RequestBody final OrderItemDto itemDto){
        OrderItem item = itemService.save(OrderItem.from(itemDto));
        return new ResponseEntity<>(OrderItemDto.from(item), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAll(){
        List<OrderItem> items = itemService.findAll();
        List<OrderItemDto> itemsDto = items.stream().map(OrderItemDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "{id}")
    public ResponseEntity<OrderItemDto> get(@PathVariable final Long id){
        OrderItem item = itemService.getItem(id);
        return new ResponseEntity<>(OrderItemDto.from(item), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<OrderItemDto> delete(@PathVariable final Long id){
        OrderItem item = itemService.delete(id);
        return new ResponseEntity<>(OrderItemDto.from(item), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "{id}")
    public ResponseEntity<OrderItemDto> edit(@PathVariable final Long id,
                                             @RequestBody final OrderItemDto itemDto){
        OrderItem editedItem = itemService.editItem(id, OrderItem.from(itemDto));
        return new ResponseEntity<>(OrderItemDto.from(editedItem), HttpStatus.OK);
    }
}
