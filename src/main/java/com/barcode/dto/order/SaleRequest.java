package com.barcode.dto.order;

import java.util.List;
import java.util.UUID;

import com.barcode.dto.orderDetail.CreateOrderDetailRequest;
import com.barcode.entities.enums.PaymentMethod;

import lombok.Data;

@Data
public class SaleRequest {

	private List<CreateOrderDetailRequest> productItems;

	private UUID customerId;

	private PaymentMethod paymentMethod;

}
