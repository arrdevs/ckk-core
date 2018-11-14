package com.keranjangkita.service;

import com.keranjangkita.model.Address;
import com.keranjangkita.repository.Custom.AddressCustomRepository;
import com.keranjangkita.repository.JPA.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressCustomRepository addressCustomRepository;

    public List<Address> getSearchBy(List<String> searchBy, List<Object> keywords, String orderBy, String orderType) {
        return addressCustomRepository.getSearchBy(searchBy, keywords, orderBy, orderType);
    };

    public void save(Address address) throws Exception {
        addressRepository.save(address);
    }

    public void saveOrUpdate(Address address) throws Exception {
        addressCustomRepository.saveOrUpdate(address);
    }

    public void delete(Address address) {
        addressRepository.delete(address);
    }
}
