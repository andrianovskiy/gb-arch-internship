package com.arch.intern.crm.backend.order.repository;

import com.arch.intern.crm.backend.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Repository
public interface ItemRepository extends JpaRepository<OrderItem, Long> {
}
