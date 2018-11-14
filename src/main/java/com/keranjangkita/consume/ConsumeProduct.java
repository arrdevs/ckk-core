package com.keranjangkita.consume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.keranjangkita.model.Item;
import com.keranjangkita.model.ItemMaster;
import com.keranjangkita.model.Merchant;
import com.keranjangkita.service.ProductService;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@Component
public class ConsumeProduct {

	RestTemplate restTemplate = new RestTemplate();
	@Autowired
	ProductService productService;
	
	public List<Merchant> searchMerchantIsAvailableByTeritory() {
		List<Merchant> merchants = new ArrayList<Merchant>();
		Merchant merchant = new Merchant();
		Merchant merchant2 = new Merchant();
		
		//merchant is available
		merchant.setMerchantCode("A001-0001");
		merchant2.setMerchantCode("A002-0001");
		
		merchants.add(merchant);
		merchants.add(merchant2);
		
		return merchants;
	}
	
	@SuppressWarnings("unchecked")
	public List<Merchant> getItems(List<ItemMaster> items){
		// method who merchant is evailable
		List<Merchant> merchants = this.searchMerchantIsAvailableByTeritory();
		List<Item> requestItems = new ArrayList<Item>();
		
		//search data local item
		List<String> itemsCode = new ArrayList();
		
		//add itemcode from list items
		for(ItemMaster im : items) {
			itemsCode.add(im.getItemCode());
		}
		
		//search data for item information from local item
		List<ItemMaster> itemsMaster = productService.findItemsMasterByItemCode(itemsCode);
		
		//setup qty and integrat qty from request to data result from database information
		for(ItemMaster searchItem : items) { 
			itemsMaster.stream()
			.filter(it -> it.getItemCode().equals(searchItem.getItemCode()))
			.findAny().orElse(null).setQty(searchItem.getQty());
		}
		
		//setup information from local information to client request
		for(ItemMaster itemMaster : itemsMaster) {
			Item item = new Item();
			item.setBarCode(itemMaster.getBarCode());
			item.setItemCode(itemMaster.getItemCode());
			item.setQty(itemMaster.getQty());
			item.setNetto(itemMaster.getNetto());
			item.setBrutto(itemMaster.getBrutto());
			item.setWeight(itemMaster.getWeight());
			item.setWeightType(itemMaster.getWeightType());
			requestItems.add(item);
		}
		
		if(!merchants.isEmpty()) {
			for(Merchant merchant : merchants) {
				merchant.setItems(requestItems);
				
			}
		}
		
		List<Merchant> merchantResults = new ArrayList<Merchant>();
		try {
			//https://skndev.herokuapp.com/api
			String baseURL = "https://skndev.herokuapp.com/api";
			merchantResults = restTemplate.postForObject(baseURL + "/product/searchmp", merchants, ArrayList.class); 
		} catch(Exception e){
			e.printStackTrace();
		}
		 
		
		return merchantResults;
	}
	
}
