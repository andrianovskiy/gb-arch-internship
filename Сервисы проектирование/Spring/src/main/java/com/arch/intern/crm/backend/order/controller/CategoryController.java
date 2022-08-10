package com.arch.intern.crm.backend.order.controller;

import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.order.model.Category;
import com.arch.intern.crm.backend.order.model.dto.CategoryDTO;
import com.arch.intern.crm.backend.order.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@RestController
@RequestMapping("/category")
@Tag(name = "Категории товаров")
public class CategoryController implements BaseController<CategoryDTO> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @PostMapping
    public ResponseEntity<CategoryDTO> add(@RequestBody final CategoryDTO categoryDTO) {
        Category category = categoryService.save(Category.from(categoryDTO));
        return new ResponseEntity<>(CategoryDTO.from(category), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<Category> items = categoryService.findAll();
        List<CategoryDTO> itemsDto = items.stream().map(CategoryDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "{id}")
    public ResponseEntity<CategoryDTO> get(@PathVariable final Long id) {
        Category item = categoryService.getCategory(id);
        return new ResponseEntity<>(CategoryDTO.from(item), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable final Long id) {
        Category item = categoryService.delete(id);
        return new ResponseEntity<>(CategoryDTO.from(item), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "{id}")
    public ResponseEntity<CategoryDTO> edit(@PathVariable final Long id,
                                        @RequestBody final CategoryDTO categoryDTO) {
        Category editedItem = categoryService.editCategory(id, Category.from(categoryDTO));
        return new ResponseEntity<>(CategoryDTO.from(editedItem), HttpStatus.OK);
    }
}
