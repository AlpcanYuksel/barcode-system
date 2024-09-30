package com.barcode.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.barcode.entities.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "barcode", unique = true, nullable = false)
	private String barcode;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "purchase_price", nullable = false)
	private double purchasePrice;

	@Column(name = "unitPrice", nullable = false)
	private double unitPrice;

	@Column(name = "quantity", nullable = false)
	private double quantity;

	@Column(name = "critical_count", nullable = false)
	private int criticalCount;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "inactive_date")
	private LocalDateTime inactiveDate;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne(mappedBy = "product")
	private ShortcutMenuItem menuItem;

	@OneToMany(mappedBy = "product")
	private List<OrderDetails> orderDetails;

}
