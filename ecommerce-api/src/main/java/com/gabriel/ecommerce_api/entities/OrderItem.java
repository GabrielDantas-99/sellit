package com.gabriel.ecommerce_api.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.ecommerce_api.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
public class OrderItem  implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();

	private Integer quantity;
	private Double price;

  public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

  @JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

}
