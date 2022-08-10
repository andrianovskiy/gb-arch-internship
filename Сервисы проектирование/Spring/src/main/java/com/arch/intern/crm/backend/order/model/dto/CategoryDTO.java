package com.arch.intern.crm.backend.order.model.dto;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import com.arch.intern.crm.backend.order.model.Category;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Setter
@Getter
public class CategoryDTO extends AbstractDTO {

    private String name;

    public static CategoryDTO from(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());

        return categoryDTO;

    }
}
