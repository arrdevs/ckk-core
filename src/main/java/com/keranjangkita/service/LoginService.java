package com.keranjangkita.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keranjangkita.model.User;
import com.keranjangkita.repository.UserRepository;

@Transactional
@Service
public class LoginService {

	@Autowired
	UserRepository userRespository;
	
	public User getUsernameByUsernameAndPassword(String username, String password) {
		return userRespository.findUserByUsernameAndPassword(username, password);
	}
}
