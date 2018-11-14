package com.keranjangkita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.keranjangkita.model.ItemMasterUnbarcode;
import com.keranjangkita.repository.ItemMasterRepository;
import com.keranjangkita.service.ItemMasterService;

@Controller
@RequestMapping("/uncoded")
public class UncodedController {

	@Autowired
	ItemMasterService itemMasterService;
	
	@RequestMapping
	@ResponseBody
	public String index() {
		return "uncoded page";
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody ItemMasterUnbarcode imu) {
		itemMasterService.save(imu);
	}
	
	@GetMapping("/getunbarcodeitem")
	@ResponseBody
	public Page<ItemMasterUnbarcode> getUnbarcodeItem(Pageable pageable){
		Page<ItemMasterUnbarcode> imus = itemMasterService.getUnbarcodeItem(pageable);
		return imus;
	}
}
