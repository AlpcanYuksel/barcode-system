package com.barcode.dto.product;

import java.util.UUID;

import lombok.Data;

@Data
public class GetProductResponse {

	private UUID id;

	private String barcode;

	private String productName;

	private double quantity;

	private double unitPrice;

}
