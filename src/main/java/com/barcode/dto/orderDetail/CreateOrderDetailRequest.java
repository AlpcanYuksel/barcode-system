package com.barcode.dto.orderDetail;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateOrderDetailRequest {

	private UUID productId;

	private double quantity;

}
