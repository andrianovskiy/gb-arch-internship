package com.arch.intern.crm.backend.order.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.order.model.dto.CategoryDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(callSuper=false)
public class Category extends AbstractEntity {
    private String name;

    @ManyToOne
    private Category category;

    public static Category from(CategoryDTO categoryDTO){
        Category item = new Category();
        item.setName(categoryDTO.getName());
        return item;
    }
}
