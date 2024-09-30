package com.barcode.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.entities.concretes.Customers;

public interface CustomerRepository extends JpaRepository<Customers, UUID> {

}
