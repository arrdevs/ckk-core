package com.keranjangkita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keranjangkita.model.Merchant;
import com.keranjangkita.repository.MerchantRepository;

@Service
@Transactional
public class MerchantService {

	@Autowired
	MerchantRepository merchantRepository;
	
	public void save(Merchant merchant) {
		merchantRepository.save(merchant);
	}
	
	public Page<Merchant> getMerchant(Pageable pageable){
		return merchantRepository.findAll(pageable);
	}

	public List<Merchant> getAll() {
		// TODO Auto-generated method stub
		List<Merchant> merchants = (List<Merchant>) merchantRepository.findAll();
		return merchants;
	} 
}
