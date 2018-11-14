package com.keranjangkita.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.keranjangkita.model.ItemMaster;
import com.keranjangkita.model.ItemMasterUnbarcode;

public interface ItemMasterUnbarcodedRespository extends PagingAndSortingRepository<ItemMasterUnbarcode, String> {

}
