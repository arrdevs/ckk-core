package com.keranjangkita.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.keranjangkita.model.Merchant;

public interface MerchantRepository extends PagingAndSortingRepository<Merchant, String>{

}
