package com.proyecto23.service;

import com.proyecto23.model.Category;
import com.proyecto23.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryImplementation implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void create(Category category) {
        if(category.getId() != null){
            if(categoryRepository.existsById(category.getId())){
                return;
            }else{
                categoryRepository.save(category);
                return;
            }
        }else {
            categoryRepository.save(category);
            return;
        }
    }

    @Override
    public List<Category> categories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Category category) {
        if (categoryRepository.existsById(category.getId())){
            categoryRepository.save(category);
            return;
        }else
            return;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return;
        }else
            return;
    }
}
