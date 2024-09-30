package com.barcode.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.entities.concretes.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, UUID> {

}
