package com.barcode.business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.core.utilities.config.mappers.ModelMapperService;
import com.barcode.core.utilities.exceptions.BusinessException;
import com.barcode.core.utilities.exceptions.Messages;
import com.barcode.dataAccess.CustomerRepository;
import com.barcode.dto.PageResponse;
import com.barcode.dto.customers.CreateCustomerRequest;
import com.barcode.dto.customers.GetAllCustomersResponse;
import com.barcode.dto.customers.UpdateCustomerRequest;
import com.barcode.entities.concretes.Customers;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapperService modelMapper;

	public Customers create(CreateCustomerRequest request) {
		Customers customer = modelMapper.forRequest().map(request, Customers.class);
		System.out.println(customer);
		return customerRepository.save(customer);

	}

	public Customers update(UpdateCustomerRequest request) {
		Customers customer = modelMapper.forRequest().map(request, Customers.class);
		return customerRepository.save(customer);
	}

	public PageResponse<GetAllCustomersResponse> getAll() {
		List<Customers> customers = customerRepository.findAll();
		List<GetAllCustomersResponse> response = customers.stream()
				.map(customer -> modelMapper.forResponse().map(customer, GetAllCustomersResponse.class)).toList();
		int responseSize = response.size();

		return new PageResponse<GetAllCustomersResponse>(responseSize, response);
	}

	public Customers getCustomer(UUID customerId) {
		Optional<Customers> oCustomer = customerRepository.findById(customerId);
		Customers customer = null;
		if (oCustomer.isPresent()) {
			customer = oCustomer.get();
		} else {
			throw new BusinessException(Messages.CUSTOMER_ID_NOT_FOUND);
		}
		return customer;
	}

}
