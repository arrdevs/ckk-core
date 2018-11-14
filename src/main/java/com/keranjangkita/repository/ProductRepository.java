package com.keranjangkita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.keranjangkita.model.ItemMaster;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ItemMaster, String> {

	@Query("select im from ItemMaster im where im.itemCode in :itemsCode")
	public List<ItemMaster> findItemMasterByItemCode(@Param("itemsCode") List<String> itemsCode);
}
