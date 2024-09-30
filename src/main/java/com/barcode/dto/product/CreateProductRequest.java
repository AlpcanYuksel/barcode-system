package com.barcode.dto.product;

import com.barcode.core.utilities.exceptions.Messages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateProductRequest {

	@NotNull(message = Messages.BARCODE_CANNOT_BE_NULL)
	@NotBlank(message = Messages.BARCODE_CANNOT_BE_BLANK)
	private String barcode;

	@NotNull(message = Messages.PRODUCT_NAME_CANNOT_BE_NULL)
	@NotBlank(message = Messages.PRODUCT_NAME_CANNOT_BE_BLANK)
	private String productName;

	@Positive(message = Messages.PURCHASE_PRICE_MUST_BE_POSITIVE)
	private double purchasePrice;

	@Positive(message = Messages.UNIT_PRICE_MUST_BE_POSITIVE)
	private double unitPrice;

	@Positive(message = Messages.QUANTITY_MUST_BE_POSITIVE)
	private double quantity;

	@Positive(message = Messages.CRITICAL_COUNT_MUST_BE_POSITIVE)
	private int criticalCount;

}
