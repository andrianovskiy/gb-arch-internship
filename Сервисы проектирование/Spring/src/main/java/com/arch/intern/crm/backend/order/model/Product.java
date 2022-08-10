package com.arch.intern.crm.backend.order.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import com.arch.intern.crm.backend.order.model.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends AbstractEntity {

    private String name;
    private Double cost;
    private String title;
    private String description;

    @ManyToOne
    private Category category;

    public static Product from(ProductDTO productDTO) {
        Product item = new Product();
        item.setName(productDTO.getName());
        item.setTitle(productDTO.getTitle());
        item.setCost(productDTO.getCost());
        item.setCategory(productDTO.getCategory());
        return item;
    }
}
