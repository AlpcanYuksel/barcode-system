package com.barcode.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.entities.concretes.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
