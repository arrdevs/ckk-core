package com.keranjangkita.repository.Custom;

import com.keranjangkita.model.Address;
import com.keranjangkita.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressCustomRepository extends BaseRepository<Address> {

    public List<Address> getSearchBy(List<String> searchBy, List<Object> keywords, String orderBy, String orderType) {
        return super.getSearchBy(Address.class, searchBy, keywords, orderBy, orderType);
    }

    public void saveOrUpdate(Address address) throws Exception {
        super.saveOrUpdate(address);
    }
}
