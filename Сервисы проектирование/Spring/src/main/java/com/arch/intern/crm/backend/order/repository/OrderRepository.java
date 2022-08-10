package com.arch.intern.crm.backend.order.repository;

import com.arch.intern.crm.backend.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
