package com.arch.intern.crm.backend.order.service;

import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.order.repository.ProductRepository;
import com.arch.intern.crm.backend.order.model.Product;
import com.arch.intern.crm.backend.order.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class ProductService implements CrudService<Product> {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public JpaRepository<Product, Long> getRepository() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    public Product getProduct(Long id) {
        return find(id).orElseThrow(() ->
                new ItemNotFoundException(id));
    }

    /**
     * @param id
     * @param item
     * @return
     */
    @Transactional
    public Product editProduct(Long id, Product item) {
        Product itemToEdit = getProduct(id);
        itemToEdit.setName(item.getName());
        itemToEdit.setTitle(item.getTitle());
        //itemToEdit.setPrice(item.getPrice());
        itemToEdit.setCategory(item.getCategory());
        return itemToEdit;
    }
}
