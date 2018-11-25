package com.keranjangkita.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keranjangkita.model.User;
import com.keranjangkita.service.LoginService;

@Controller
@RequestMapping("/api/userlogin/")
public class LoginApiController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login")
	public User getUserApp(@RequestParam("username") String username,@RequestParam("password") String password) {
		User user = loginService.getUsernameByUsernameAndPassword(username, password);
		return user;
	}
}
