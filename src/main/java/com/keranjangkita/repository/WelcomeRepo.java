package com.keranjangkita.repository;

import com.keranjangkita.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WelcomeRepo extends BaseRepository<Person> {

    @Autowired
    EntityManager entityManager;

    //public Welcome getWelcome() {
    //    return getWelcome();
    //}

    public List<Person> getAll() throws Exception {
        return getAll(Person.class);
    }

    public List<Person> getAllPerson() {
        return entityManager.createQuery("SELECT x FROM Person x").getResultList();
    }
}
