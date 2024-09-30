package com.barcode.dto.product;

import java.util.UUID;

import lombok.Data;

@Data
public class GetAllProductResponse {

	private UUID id;

	private String barcode;

	private String productName;

	private double purchasePrice;

	private double unitPrice;

	private double quantity;

	private int criticalCount;

	private String categoryName;

}
