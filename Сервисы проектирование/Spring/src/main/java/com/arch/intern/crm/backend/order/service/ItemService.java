package com.arch.intern.crm.backend.order.service;

import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.order.repository.ItemRepository;
import com.arch.intern.crm.backend.order.model.OrderItem;
import com.arch.intern.crm.backend.order.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class ItemService implements CrudService<OrderItem> {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public JpaRepository<OrderItem, Long> getRepository() {
        return itemRepository;
    }

    /**
     *
     * @param id
     * @return
     */
    public OrderItem getItem(Long id){
        return find(id).orElseThrow(() ->
                new ItemNotFoundException(id));
    }

    /**
     *
     * @param id
     * @param item
     * @return
     */
    @Transactional
    public OrderItem editItem(Long id, OrderItem item){
        OrderItem itemToEdit = getItem(id);
        itemToEdit.setQty(item.getQty());
        return itemToEdit;
    }


}
