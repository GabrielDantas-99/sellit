package com.gabriel.ecommerce_api.repositories;

import com.gabriel.ecommerce_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
