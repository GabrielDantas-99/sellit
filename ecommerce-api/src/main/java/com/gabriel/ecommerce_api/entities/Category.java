package com.gabriel.ecommerce_api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private final Set<Product> products = new HashSet<>();

}
