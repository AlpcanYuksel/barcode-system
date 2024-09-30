package com.barcode.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.core.utilities.config.mappers.ModelMapperService;
import com.barcode.core.utilities.exceptions.BusinessException;
import com.barcode.core.utilities.exceptions.Messages;
import com.barcode.dataAccess.ProductRepository;
import com.barcode.dto.PageResponse;
import com.barcode.dto.product.GetAllProductResponse;
import com.barcode.dto.product.GetProductResponse;
import com.barcode.entities.concretes.Product;
import com.barcode.entities.enums.Status;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapperService modelMapper;

	public Product create(Product product) {
		product.setCreatedDate(LocalDateTime.now());
		product.setStatus(Status.ACTIVE);
		return productRepository.save(product);
	}

	public Product update(Product product) {
		product.setCreatedDate(LocalDateTime.now());
		product.setStatus(Status.ACTIVE);
		return productRepository.save(product);
	}

	public GetProductResponse getProductByBarcode(String barcode) {
		// Ürünü veritabanından al
		Product product = productRepository.findByBarcode(barcode);

		// Ürün bulunamadıysa uygun bir yanıt döndür
		if (product == null) {
			throw new BusinessException(Messages.BARCODE_CANNOT_BE_NULL);
		}

		// ModelMapper ile dönüşüm yap
		GetProductResponse response = modelMapper.forResponse().map(product, GetProductResponse.class);

		return response;
	}

	public PageResponse<GetAllProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		List<GetAllProductResponse> response = products.stream()
				.map(product -> modelMapper.forResponse().map(product, GetAllProductResponse.class)).toList();
		int responseSize = response.size();

		return new PageResponse<GetAllProductResponse>(responseSize, response);
	}

	public Product getProduct(UUID productId) {
		Optional<Product> oProduct = productRepository.findById(productId);
		Product product = null;
		if (oProduct.isPresent()) {
			product = oProduct.get();
		} else {
			throw new BusinessException(Messages.BARCODE_CANNOT_BE_BLANK);
		}
		return product;
	}

}
