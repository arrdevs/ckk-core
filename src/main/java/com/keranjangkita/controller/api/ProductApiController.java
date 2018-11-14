package com.keranjangkita.controller.api;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.keranjangkita.consume.ConsumeProduct;
import com.keranjangkita.model.Customer;
import com.keranjangkita.model.Item;
import com.keranjangkita.model.ItemMaster;
import com.keranjangkita.model.Merchant;
import com.keranjangkita.service.CustomerService;
import com.keranjangkita.service.ItemMasterService;

@RestController
@RequestMapping("/api/products/")
public class ProductApiController {

	@Autowired
	private ItemMasterService itemMastetService;
	
	@Autowired
	private ConsumeProduct consumeProduct;
	
	@GetMapping("/get")
	public Page<ItemMaster> helloController(Pageable pageable) {
		Page<ItemMaster> items = itemMastetService.getItems(pageable);
		
		return items;
	}
	
	@GetMapping("/search")
	public Page<ItemMaster> searchProduct(@RequestParam("keyword") String keyword, Pageable pageable) {
		Page<ItemMaster> items =itemMastetService.searchItemMaster(keyword, pageable);
		return items;		
	}
	
	@RequestMapping(value="/searchitemmerchant", method=RequestMethod.POST)
	@ResponseBody
	public List<Merchant> searchItemsSelected(@RequestBody List<ItemMaster> itemsMaster) {
		List<Merchant> productMerchants = consumeProduct.getItems(itemsMaster);
		return productMerchants;
	}
	
}
