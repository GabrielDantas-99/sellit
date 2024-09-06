package com.gabriel.ecommerce_api.services;

import com.gabriel.ecommerce_api.entities.Order;
import com.gabriel.ecommerce_api.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(UUID id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
