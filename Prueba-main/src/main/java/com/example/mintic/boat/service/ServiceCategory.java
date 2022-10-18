package com.example.mintic.boat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.boat.model.Category;
import com.example.mintic.boat.repository.RepositoryCategory;

@Service
public class ServiceCategory {
    
    @Autowired
    private RepositoryCategory repositoryCategory;

    
    public List<Category> getAll() {
        return repositoryCategory.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return repositoryCategory.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return repositoryCategory.save(category);
        } else {
            Optional<Category> category1 = repositoryCategory.getCategory(category.getId());
            if (category1.isEmpty()) {
                return repositoryCategory.save(category);
            } else {
                return category;
            }
        }
    }
    public boolean delete(int id) {
        return repositoryCategory.delete(id);
    }


    public Category update(Category category ) {
        return repositoryCategory.save(category);
    }



}

