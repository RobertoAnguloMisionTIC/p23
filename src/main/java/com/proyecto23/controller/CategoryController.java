package com.proyecto23.controller;

import com.proyecto23.model.Box;
import com.proyecto23.model.Category;
import com.proyecto23.service.BoxImplementation;
import com.proyecto23.service.CategoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryImplementation categoryImplementation;

    @PostMapping("/save")
    public void createCategory(@RequestBody Category category){
        categoryImplementation.create(category);
    }

    @GetMapping("/all")
    public List<Category> getCategories(){
        return categoryImplementation.categories();
    }

    @PutMapping("/update")
    public void updateCategory(@RequestBody Category category){
        categoryImplementation.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable ("id") Integer id){
        categoryImplementation.delete(id);
    }
}
