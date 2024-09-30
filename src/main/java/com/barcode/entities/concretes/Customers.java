package com.barcode.entities.concretes;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue
	private UUID id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "address")
	private String address;

	@Column(name = "contact_phone")
	private String contactPhone;

	@Column(name = "contact_email")
	private String contactEmail;

	@OneToMany(mappedBy = "customer")
	private List<Orders> orders;

}
