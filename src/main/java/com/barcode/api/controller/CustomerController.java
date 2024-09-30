package com.barcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.business.CustomerService;
import com.barcode.dto.PageResponse;
import com.barcode.dto.SuccessResponse;
import com.barcode.dto.customers.CreateCustomerRequest;
import com.barcode.dto.customers.GetAllCustomersResponse;
import com.barcode.dto.customers.UpdateCustomerRequest;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public SuccessResponse create(@RequestBody CreateCustomerRequest request) {
		customerService.create(request);
		return new SuccessResponse();
	}

	@PutMapping("/update")
	public SuccessResponse create(@RequestBody UpdateCustomerRequest request) {
		customerService.update(request);
		return new SuccessResponse();
	}

	@GetMapping("/getAll")
	public PageResponse<GetAllCustomersResponse> getAll() {
		return customerService.getAll();
	}

}
