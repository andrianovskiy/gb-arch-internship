package com.arch.intern.crm.backend.order.controller;

import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.order.model.Product;
import com.arch.intern.crm.backend.order.model.dto.ProductDTO;
import com.arch.intern.crm.backend.order.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : danil in 08.07.2021
 **/
@RestController
@RequestMapping("/product")
@Tag(name = "Товары")
public class ProductController implements BaseController<ProductDTO> {
    
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @Override
    @PostMapping
    public ResponseEntity<ProductDTO> add(@RequestBody final ProductDTO productDTO) {
        Product product = productService.save(Product.from(productDTO));
        return new ResponseEntity<>(ProductDTO.from(product), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> items = productService.findAll();
        List<ProductDTO> itemsDto = items.stream().map(ProductDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable final Long id) {
        Product item = productService.getProduct(id);
        return new ResponseEntity<>(ProductDTO.from(item), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable final Long id) {
        Product item = productService.delete(id);
        return new ResponseEntity<>(ProductDTO.from(item), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "{id}")
    public ResponseEntity<ProductDTO> edit(@PathVariable final Long id,
                                            @RequestBody final ProductDTO ProductDTO) {
        Product editedItem = productService.editProduct(id, Product.from(ProductDTO));
        return new ResponseEntity<>(ProductDTO.from(editedItem), HttpStatus.OK);
    }
}
