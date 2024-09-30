package com.barcode.entities.concretes;

import java.util.List;
import java.util.UUID;

import com.barcode.entities.enums.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customer;

	@Column(name = "order_date")
	private String orderDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod;

	@Column(name = "order_price")
	private double orderPrice;

	@OneToMany(mappedBy = "order")
	private List<OrderDetails> orderDetails;

}
