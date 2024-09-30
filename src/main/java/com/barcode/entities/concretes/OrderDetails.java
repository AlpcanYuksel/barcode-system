package com.barcode.entities.concretes;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_details")
public class OrderDetails {

	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "quantity")
	private double quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;

}
