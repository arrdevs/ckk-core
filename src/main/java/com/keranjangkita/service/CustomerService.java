package com.keranjangkita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keranjangkita.model.Customer;
import com.keranjangkita.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Page<Customer> getCustomers(Pageable pageable){
		return customerRepository.findAll(pageable);
	}
	
}
