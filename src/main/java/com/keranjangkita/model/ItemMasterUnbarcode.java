package com.keranjangkita.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ITEM_MASTER_UNBARCODE")
public class ItemMasterUnbarcode {
	
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "master_item_unbarcode_id")
	private String id;
	@Column(name="merchant_item_code")
	private String merchantItemCode;
	@ManyToOne
	@JoinColumn(name="item_master_id")
	private ItemMaster itemMaster;
	@Column(name="merchant_code")
	private String merchantCode;
	
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMerchantItemCode() {
		return merchantItemCode;
	}
	public void setMerchantItemCode(String merchantItemCode) {
		this.merchantItemCode = merchantItemCode;
	}
	public ItemMaster getItemMaster() {
		return itemMaster;
	}
	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}
}
