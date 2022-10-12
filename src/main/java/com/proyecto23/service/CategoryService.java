package com.proyecto23.service;

import com.proyecto23.model.Box;
import com.proyecto23.model.Category;

import java.util.List;

public interface CategoryService {
    public void create(Category category);
    public List<Category> categories();
    public void update(Category category);
    public void delete(Integer id);
}
