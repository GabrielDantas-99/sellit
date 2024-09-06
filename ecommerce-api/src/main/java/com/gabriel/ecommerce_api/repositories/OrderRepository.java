package com.gabriel.ecommerce_api.repositories;

import com.gabriel.ecommerce_api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
