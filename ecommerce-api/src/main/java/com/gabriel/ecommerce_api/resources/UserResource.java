package com.gabriel.ecommerce_api.resources;

import com.gabriel.ecommerce_api.entities.User;
import com.gabriel.ecommerce_api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable UUID id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

    @PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(obj.getId())
                    .toUri();
		return ResponseEntity.created(uri).body(obj);
	}

    @PutMapping(value = "/{id}")
	public ResponseEntity<User> update(
        @PathVariable UUID id, @RequestBody User obj
    ) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
