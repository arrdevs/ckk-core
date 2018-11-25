package com.keranjangkita.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.keranjangkita.model.ItemMaster;
import com.keranjangkita.model.User;
import com.keranjangkita.repository.UserRepository;
import com.keranjangkita.service.LoginService;

@Controller
@RequestMapping("/api/user/")
public class UserApiController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody User user) {
		userRepository.save(user);
	}
	
}
