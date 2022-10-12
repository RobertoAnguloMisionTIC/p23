package com.proyecto23.service;

import com.proyecto23.model.Box;
import com.proyecto23.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category create(Category category);
    public Optional<Category> getCategory(Integer id);
    public List<Category> categories();
    public void update(Category category);
    public void delete(Integer id);
}
