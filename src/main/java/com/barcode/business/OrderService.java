package com.barcode.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.dataAccess.OrderDetailRepository;
import com.barcode.dataAccess.OrderRepository;
import com.barcode.dto.orderDetail.CreateOrderDetailRequest;
import com.barcode.entities.concretes.Customers;
import com.barcode.entities.concretes.OrderDetails;
import com.barcode.entities.concretes.Orders;
import com.barcode.entities.concretes.Product;
import com.barcode.entities.enums.PaymentMethod;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Transactional
	public void create(List<CreateOrderDetailRequest> productItems, UUID customerId, PaymentMethod paymentMethod) {

		Customers customer = (customerId != null) ? customerService.getCustomer(customerId) : null;

		List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String formattedDateTime = now.format(formatter);

		Orders order = Orders.builder().customer(customer).orderDate(formattedDateTime).build();
		order.setPaymentMethod(paymentMethod);

		for (CreateOrderDetailRequest productItem : productItems) {
			Product product = productService.getProduct(productItem.getProductId());
			product.setQuantity(product.getQuantity() - productItem.getQuantity());
			OrderDetails orderDetail = OrderDetails.builder().order(order).product(product)
					.quantity(productItem.getQuantity()).unitPrice(product.getUnitPrice())
					.totalPrice(productItem.getQuantity() * product.getUnitPrice()).build();
			orderDetailsList.add(orderDetail);

		}
		;

		double totalPriceSum = orderDetailsList.stream().mapToDouble(od -> od.getTotalPrice()).sum();
		order.setOrderPrice(totalPriceSum);
		orderRepository.save(order);
		orderDetailRepository.saveAll(orderDetailsList);

	}

}
