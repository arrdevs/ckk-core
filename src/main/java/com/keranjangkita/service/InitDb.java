package com.keranjangkita.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.keranjangkita.model.Customer;
import com.keranjangkita.model.ItemMaster;
import com.keranjangkita.model.User;

@Component
public class InitDb {

	@Autowired
	private CustomerService cs;
	@Autowired
	ItemMasterService itemMasterService;
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	public void construct() throws IOException {
		List<ItemMaster> items = new ArrayList();
		
		//default user
		User user = new User();
		user.setUsername("skn");
		user.setPassword("mitra2018");
		user.setStatus("active");
		user.setToken("2c93e8126748d47c016748d492650000");
		user.setCreatedAt(new Date());
		userService.saveUser(user);
		
		   Resource resource = new ClassPathResource("/static/sample_merchant_short_complate.xlsx");
		   InputStream dbAsStream = resource.getInputStream();
		   
		   XSSFWorkbook workbook = new XSSFWorkbook(dbAsStream);
		    XSSFSheet worksheet = workbook.getSheetAt(0);   
		    DataFormatter formatter = new DataFormatter();
		    for(int i=1;i< worksheet.getPhysicalNumberOfRows();i++) {
		        XSSFRow row = worksheet.getRow(i);
			        String itemId = formatter.formatCellValue(row.getCell(1));
			        String merchantCode = formatter.formatCellValue(row.getCell(2));
			        String itemCode = formatter.formatCellValue(row.getCell(3));
			        String barCode = formatter.formatCellValue(row.getCell(4));
			        String name = formatter.formatCellValue(row.getCell(5));
			        
			        String netto = formatter.formatCellValue(row.getCell(6));
			        String brutto = formatter.formatCellValue(row.getCell(7));
			        String loi = formatter.formatCellValue(row.getCell(8));
			        String hoi = formatter.formatCellValue(row.getCell(9));
			        String woi = formatter.formatCellValue(row.getCell(10));
			        String desc =formatter.formatCellValue(row.getCell(11));
			        String stock = formatter.formatCellValue(row.getCell(12));
			        double price = (row.getCell(13) != null) ? row.getCell(13).getNumericCellValue() : 0;
			        String status = formatter.formatCellValue(row.getCell(14));
			        String uom = formatter.formatCellValue(row.getCell(15));
			        String weight = formatter.formatCellValue(row.getCell(16));
			        String weightType =formatter.formatCellValue(row.getCell(17));
			        String imageUrl = formatter.formatCellValue(row.getCell(18));
			        String amountAvailability = formatter.formatCellValue(row.getCell(19));
			        
			        ItemMaster item = new ItemMaster();
			        item.setId(itemId);
			        //item.setMerchantCode(merchantCode);
			        item.setItemCode(itemCode);
			        item.setName(name);
			        item.setBarCode(barCode);
			        item.setNetto(netto);
			        item.setBrutto(brutto);
			        item.setLengthOfItem(loi);
			        item.setLengthOfItem(hoi);
			        item.setWidthOfItem(woi);
			        item.setDescription(desc);
			        item.setInStock(Integer.parseInt(stock));
			       // item.setPrice(Double.parseDouble(price));
			        item.setStatus(status);
			        item.setUom(uom);
			        item.setWeight(weight);
			        item.setWeightType(weightType);
			        item.setImageUrl(imageUrl);
			        item.setAmount_availability(Integer.parseInt(amountAvailability));
			        items.add(item);
			}
		    if(!items.isEmpty()) {
		    	itemMasterService.save(items);
		    }	    
	}
}
