package com.barcode.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.core.utilities.config.mappers.ModelMapperService;
import com.barcode.dataAccess.CategoryRepository;
import com.barcode.dto.PageResponse;
import com.barcode.dto.category.CreateCategoryRequest;
import com.barcode.dto.category.GetCategoryResponse;
import com.barcode.dto.category.UpdateCategoryRequest;
import com.barcode.entities.concretes.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Autowired
	private ModelMapperService modelMapper;

	public Category create(CreateCategoryRequest request) {

		Category category = modelMapper.forRequest().map(request, Category.class);
		return repository.save(category);
	}

	public Category update(UpdateCategoryRequest request) {

		Category category = modelMapper.forRequest().map(request, Category.class);

		return repository.save(category);
	}

	public PageResponse<GetCategoryResponse> getAllCategory() {
		List<Category> categories = repository.findAll();
		List<GetCategoryResponse> response = categories.stream()
				.map(category -> modelMapper.forResponse().map(category, GetCategoryResponse.class)).toList();
		int responseSize = categories.size();
		return new PageResponse<GetCategoryResponse>(responseSize, response);

	}

}
