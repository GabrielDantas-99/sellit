package com.gabriel.ecommerce_api.repositories;

import com.gabriel.ecommerce_api.entities.OrderItem;
import com.gabriel.ecommerce_api.entities.pk.OrderItemPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
