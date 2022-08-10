package com.arch.intern.crm.backend.order.repository;

import com.arch.intern.crm.backend.order.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Marchenko_DS in 25/04/2022
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
