package com.gabriel.ecommerce_api.services;

import com.gabriel.ecommerce_api.entities.User;
import com.gabriel.ecommerce_api.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

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

    public User create(User obj) {
		return repository.save(obj);
	}

    public User update(UUID id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
	}

    private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
