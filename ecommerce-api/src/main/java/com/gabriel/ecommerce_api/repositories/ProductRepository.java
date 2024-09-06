package com.gabriel.ecommerce_api.repositories;

import com.gabriel.ecommerce_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
