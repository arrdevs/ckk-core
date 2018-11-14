package com.keranjangkita.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.keranjangkita.model.Customer;
import com.keranjangkita.model.Item;
import com.keranjangkita.model.ItemMaster;
import com.keranjangkita.model.ItemMasterUnbarcode;
import com.keranjangkita.model.Merchant;
import com.keranjangkita.repository.ItemMasterRepository;
import com.keranjangkita.repository.ItemMasterUnbarcodedRespository;

@Service
@Transactional
public class ItemMasterService {
	
	@Autowired
	private ItemMasterRepository itemRespository;
	@Autowired
	private ItemMasterUnbarcodedRespository itemMasterUnbarcodedRespository;

	public Page<ItemMaster> getItems(Pageable pageable){
		return itemRespository.findAll(pageable);
	}
	
	public Page<ItemMaster> searchItemMaster(String keyword, Pageable pageable){
		return itemRespository.findByNameIgnoreCaseContaining(keyword, pageable);
	}
	
	public void save(ItemMaster itemMaster) {
		itemRespository.save(itemMaster);
	}
	
	//unbarcoded
	public void save(ItemMasterUnbarcode imu) {
		itemMasterUnbarcodedRespository.save(imu);
	}
	
	public Page<ItemMasterUnbarcode> getItemMasterUnbarcode(Pageable pageable){
		return itemMasterUnbarcodedRespository.findAll(pageable);
	}

	public Page<ItemMasterUnbarcode> getUnbarcodeItem(Pageable pageable) {
		// TODO Auto-generated method stub
		return itemMasterUnbarcodedRespository.findAll(pageable);
	}

	public void save(List<ItemMaster> items) {
		// TODO Auto-generated method stub
		itemRespository.saveAll(items);
		
	}
}
