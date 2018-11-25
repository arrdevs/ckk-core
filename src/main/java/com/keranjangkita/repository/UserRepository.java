package com.keranjangkita.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.keranjangkita.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>{

	public User findUserByUsernameAndPassword(String username, String password);
}
