package com.gabriel.ecommerce_api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.ecommerce_api.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	private Integer orderStatus;

	public Order(UUID id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

}
