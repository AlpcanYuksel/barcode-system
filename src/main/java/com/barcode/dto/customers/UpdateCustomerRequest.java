package com.barcode.dto.customers;

import java.util.UUID;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

	private UUID id;

	private String customerName;

	private String address;

	private String contactPhone;

	private String contactEmail;

}
