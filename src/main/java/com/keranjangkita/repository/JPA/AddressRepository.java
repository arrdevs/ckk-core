package com.keranjangkita.repository.JPA;

import com.keranjangkita.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {

}
