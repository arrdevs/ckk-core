package com.keranjangkita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.keranjangkita.model.Merchant;
import com.keranjangkita.service.MerchantService;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	MerchantService merchantService;
	
	@RequestMapping
	@ResponseBody
	public String index() {
		return "merchant page";
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Merchant merchant) {
		merchantService.save(merchant);
	}
	
	@RequestMapping(value="/getall")
	@ResponseBody
	public List<Merchant> getAll(){
		return merchantService.getAll();
	}
}
