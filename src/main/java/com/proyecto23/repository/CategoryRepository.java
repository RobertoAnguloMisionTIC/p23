package com.proyecto23.repository;

import com.proyecto23.model.Box;
import com.proyecto23.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
