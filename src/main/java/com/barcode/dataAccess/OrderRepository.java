package com.barcode.dataAccess;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.barcode.dto.order.CategoryRevenueResponseDTO;
import com.barcode.entities.concretes.Orders;

public interface OrderRepository extends JpaRepository<Orders, UUID> {
//    @Query("SELECT new com.example.dto.CategoryRevenueDTO(c.categoryName, SUM(od.totalPrice)) " +
//	           "FROM Orders o " +
//	           "JOIN o.orderDetails od " +
//	           "JOIN od.product p " +
//	           "JOIN p.category c " +
//	           "WHERE o.orderDate = :orderDate " +
//	           "GROUP BY c.categoryName")
//	    List<CategoryRevenueResponseDTO> findDailyRevenueByCategory(@Param("orderDate") String orderDate);
	
//    @Query("SELECT new com.barcode.dto.DailySalesDTO(DAY(o.orderDate), SUM(o.orderPrice)) " +
//            "FROM Orders o " +
//            "WHERE MONTH(o.orderDate) = :month " +
//            "GROUP BY DAY(o.orderDate)")
//     List<DailySalesDTO> getSalesForMonth(@Param("month") int month);
	

}
