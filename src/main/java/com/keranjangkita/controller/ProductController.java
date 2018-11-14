package com.keranjangkita.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.keranjangkita.model.Item;

@Controller
@RequestMapping("/product")
public class ProductController {

	@RequestMapping
	public String index() {
		return "upload";
	}
	
	@PostMapping("/import2")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
	   List<Item> tempStudentList = new ArrayList();
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
//	        Test tempStudent = new Test();
//
	        XSSFRow row = worksheet.getRow(i);
	        int number = 0;
	        
	        System.out.println("loop : "+ row.getCell(0).getNumericCellValue());
	        
//	        tempStudent.setId((int) row.getCell(0).getNumericCellValue());
//	        tempStudent.setContent(row.getCell(1).getStringCellValue());
//	            tempStudentList.add(tempStudent);   
	    }
	}
	
}
