package com.keranjangkita.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keranjangkita.model.ConfigurationExample;
import com.keranjangkita.model.Person;
import com.keranjangkita.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController{

	@Autowired
	private WelcomeService welcomeService;

	@Autowired
	private ConfigurationExample configurationExample;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	/*
	@GetMapping("/test")
	public ResponseEntity<Map<String, Object>> test() {
		Map<String, Object> responseResult = new HashMap<>();
		responseResult.put("person", welcomeService.getAll());
		return new ResponseEntity<>(responseResult, HttpStatus.OK);
	}
	*/

	@RequestMapping(value = "/testJson",method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> testJson(@RequestBody Map<String, Object> request) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> responseResult = new HashMap<>();
		Person orang = mapper.convertValue(request.get("isi"),Person.class);
		responseResult.put("nama", orang.getNama());
		responseResult.put("alamat", orang.getAlamat());
		return new ResponseEntity<>(responseResult, HttpStatus.OK);
	}
}