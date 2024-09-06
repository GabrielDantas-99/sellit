package com.gabriel.ecommerce_api.services;

import com.gabriel.ecommerce_api.entities.Product;
import com.gabriel.ecommerce_api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(UUID id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
