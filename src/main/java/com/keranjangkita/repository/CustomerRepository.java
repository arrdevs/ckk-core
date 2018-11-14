package com.keranjangkita.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.keranjangkita.model.Customer;


public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

	
}
