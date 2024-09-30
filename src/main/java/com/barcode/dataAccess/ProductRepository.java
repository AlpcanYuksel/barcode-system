package com.barcode.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
	Product findByBarcode(String barcode);
}
