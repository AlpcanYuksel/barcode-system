package com.barcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.business.ProductService;
import com.barcode.core.utilities.config.mappers.ModelMapperService;
import com.barcode.dto.PageResponse;
import com.barcode.dto.product.CreateProductRequest;
import com.barcode.dto.product.GetAllProductResponse;
import com.barcode.dto.product.GetProductResponse;
import com.barcode.dto.product.UpdateProductRequest;
import com.barcode.entities.concretes.Product;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ModelMapperService modelMapperService;

	@PostMapping("/create")
	public void create(@Valid @RequestBody CreateProductRequest request) {
		Product product = modelMapperService.forRequest().map(request, Product.class);
		productService.create(product);

	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateProductRequest request) {
		Product product = modelMapperService.forRequest().map(request, Product.class);
		productService.update(product);
	}

	@GetMapping("getProductByBarcode")
	public GetProductResponse getProductByBarcode(@RequestParam String barcode) {
		return productService.getProductByBarcode(barcode);
	}

	@GetMapping("getAll")
	public PageResponse<GetAllProductResponse> getAll() {
		return productService.getAllProducts();

	}

}
