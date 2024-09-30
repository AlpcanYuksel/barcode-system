package com.barcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.business.OrderService;
import com.barcode.dto.SuccessResponse;
import com.barcode.dto.order.SaleRequest;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public SuccessResponse create(@RequestBody SaleRequest request) {

		orderService.create(request.getProductItems(), request.getCustomerId(), request.getPaymentMethod());
		return new SuccessResponse();

	}

}
