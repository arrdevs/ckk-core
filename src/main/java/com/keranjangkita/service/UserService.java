package com.keranjangkita.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keranjangkita.model.User;
import com.keranjangkita.repository.UserRepository;

@Transactional
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
}
