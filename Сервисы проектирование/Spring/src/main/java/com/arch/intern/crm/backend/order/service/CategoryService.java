package com.arch.intern.crm.backend.order.service;

import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.order.repository.CategoryRepository;
import com.arch.intern.crm.backend.order.model.Category;
import com.arch.intern.crm.backend.order.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class CategoryService implements CrudService<Category> {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    /**
     *
     * @param id
     * @return
     */
    public Category getCategory(Long id){
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
    public Category editCategory(Long id, Category item){
        Category itemToEdit = getCategory(id);
        itemToEdit.setName(item.getName());
        return itemToEdit;
    }

}
