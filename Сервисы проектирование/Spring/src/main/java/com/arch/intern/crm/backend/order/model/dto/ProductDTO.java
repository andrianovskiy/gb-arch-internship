package com.arch.intern.crm.backend.order.model.dto;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import com.arch.intern.crm.backend.order.model.Category;
import com.arch.intern.crm.backend.order.model.Product;
import lombok.Getter;
import lombok.Setter;



/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
public class ProductDTO extends AbstractDTO {

    private String name;
    private Double cost;
    private String title;
    private Category category;

    public static ProductDTO from(Product product) {
        ProductDTO item = new ProductDTO();
        item.setName(product.getName());
        item.setTitle(product.getTitle());
        item.setCost(product.getCost());
        item.setCategory(product.getCategory());
        return item;
    }

}
