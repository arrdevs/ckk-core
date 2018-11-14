package com.keranjangkita.service;

import com.keranjangkita.model.Person;
import com.keranjangkita.repository.WelcomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WelcomeService {

    @Autowired
    private WelcomeRepo welcomeRepo;

    //public List<Person> getAll() {
     //return welcomeRepo.getAll();
    //}

    public List<Person> getAllPerson() {
        return welcomeRepo.getAllPerson();
    }
}
