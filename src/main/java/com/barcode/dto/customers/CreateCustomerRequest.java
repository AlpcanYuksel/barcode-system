package com.barcode.dto.customers;

import lombok.Data;

@Data
public class CreateCustomerRequest {

	private String customerName;

	private String address;

	private String contactPhone;

	private String contactEmail;

}
