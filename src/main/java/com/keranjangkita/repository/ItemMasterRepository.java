package com.keranjangkita.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.keranjangkita.model.Customer;
import com.keranjangkita.model.Item;
import com.keranjangkita.model.ItemMaster;


public interface ItemMasterRepository extends PagingAndSortingRepository<ItemMaster, String> {

	public Page<ItemMaster> findByNameIgnoreCaseContaining(String keyword, Pageable pageable);
}
