package com.barcode.dto.category;

import java.util.UUID;

import lombok.Data;

@Data
public class GetCategoryResponse {

	private UUID id;

	private String categoryName;

}