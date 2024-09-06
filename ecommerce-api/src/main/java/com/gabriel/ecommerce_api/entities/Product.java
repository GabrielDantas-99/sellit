package com.gabriel.ecommerce_api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

  @ManyToMany
	@JoinTable(
    name = "tb_product_category", 
    joinColumns = @JoinColumn(name = "product_id"), 
    inverseJoinColumns = @JoinColumn(name = "category_id"))
	private final Set<Category> categories = new HashSet<>();
	
}
