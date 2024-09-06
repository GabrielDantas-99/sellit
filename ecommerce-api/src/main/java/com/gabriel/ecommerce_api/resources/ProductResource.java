package com.gabriel.ecommerce_api.resources;

import com.gabriel.ecommerce_api.entities.Product;
import com.gabriel.ecommerce_api.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable UUID id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
