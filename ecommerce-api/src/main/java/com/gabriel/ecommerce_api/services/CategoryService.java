package com.gabriel.ecommerce_api.services;

import com.gabriel.ecommerce_api.entities.Category;
import com.gabriel.ecommerce_api.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(UUID id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
