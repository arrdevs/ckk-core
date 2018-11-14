package com.keranjangkita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.keranjangkita.model.ItemMaster;
import com.keranjangkita.repository.ProductRepository;

@Transactional
@Service
public class ProductService {
	
	@Autowired
	ProductRepository productDao;

	public List<ItemMaster> findItemsMasterByItemCode(List<String> itemsCode) {
		// TODO Auto-generated method stub
		return productDao.findItemMasterByItemCode(itemsCode);
	}

}
