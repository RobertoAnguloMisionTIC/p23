package com.proyecto23.service;

import com.proyecto23.model.Box;
import com.proyecto23.model.Category;
import com.proyecto23.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryImplementation implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        if (category.getId() == null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> categoryNew = getCategory(category.getId());
            if (categoryNew.isEmpty()){
                return categoryRepository.save(category);
            }else {
                return category;
            }
        }
    }

    @Override
    public Optional<Category> getCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> categories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        if (category != null && category.getId() != null){
            if (categoryRepository.existsById(category.getId())){
                Optional<Category> oldCategory = categoryRepository.findById(category.getId());
                Category editedCategory = oldCategory.get();
                if (category.getName() != null){
                    editedCategory.setName(category.getName());
                }
                if (category.getDescription() != null){
                    editedCategory.setDescription(category.getDescription());
                }
                if (category.getBoxes() != null){
                    editedCategory.setBoxes(category.getBoxes());
                }
                return categoryRepository.save(editedCategory);
            }else{
                return category;
            }
        }else {
            return category;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }else
            return true;
    }
}
