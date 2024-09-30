package com.barcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.business.CategoryService;
import com.barcode.dto.PageResponse;
import com.barcode.dto.category.CreateCategoryRequest;
import com.barcode.dto.category.GetCategoryResponse;
import com.barcode.dto.category.UpdateCategoryRequest;
import com.barcode.entities.concretes.Category;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create")
	public Category create(@RequestBody CreateCategoryRequest request) {
		return categoryService.create(request);
	}

	@PutMapping("/update")
	public Category update(@RequestBody UpdateCategoryRequest request) {
		return categoryService.update(request);
	}

	@GetMapping("/get")
	public PageResponse<GetCategoryResponse> getAllCategory() {
		return categoryService.getAllCategory();

	}

}
