package com.gabriel.ecommerce_api.services;

import com.gabriel.ecommerce_api.entities.User;
import com.gabriel.ecommerce_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(UUID id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
