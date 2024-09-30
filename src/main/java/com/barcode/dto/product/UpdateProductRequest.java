package com.barcode.dto.product;

import java.util.UUID;

import lombok.Data;

@Data
public class UpdateProductRequest {

	private UUID id;

	private UUID categoryId;

	private String barcode;

	private String productName;

	private double purchasePrice;

	private double unitPrice;

	private double quantity;

	private int criticalCount;

}
