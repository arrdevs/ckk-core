package com.keranjangkita.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "item_id")
    private String id;
	@Column(name="item_code")
	private String itemCode;
	@Column(name="bar_code")
	private String barCode;
	private String name;
	private String price;
	private String weight;
	@Column(name="weight_type")
	private String weightType;
	private String stock;
	private String description;
	@Column(name="image_url")
	private String imageUrl;
	private String status;
	@Column(name="create_user")
	private String createUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	@ManyToMany(cascade = CascadeType.ALL)
 	@JoinTable(name = "item_categories", 
 		joinColumns = @JoinColumn(name = "item_id"), 
 			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	@ManyToOne
	@JoinColumn(name="merchant_id")
	private Merchant merchant;
	@ManyToOne
	@JoinColumn(name="item_master")
	private ItemMaster itemMaster;
	@OneToMany(mappedBy="items", fetch=FetchType.LAZY)
	private List<CartPromotion> cartPromotions;
	@OneToMany(mappedBy="items", fetch=FetchType.LAZY)
	private List<DetailTransaction> detailTransactions;
	private String note;
	private String netto;
	private String brutto;
	@Transient
	private String statusItem;
	@Transient
	private String statusStock;
	@Transient
	private int qty;
	
	
	public String getNetto() {
		return netto;
	}
	public void setNetto(String netto) {
		this.netto = netto;
	}
	public String getBrutto() {
		return brutto;
	}
	public void setBrutto(String brutto) {
		this.brutto = brutto;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatusItem() {
		return statusItem;
	}
	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}
	public String getStatusStock() {
		return statusStock;
	}
	public void setStatusStock(String statusStock) {
		this.statusStock = statusStock;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public List<DetailTransaction> getDetailTransactions() {
		return detailTransactions;
	}
	public void setDetailTransactions(List<DetailTransaction> detailTransactions) {
		this.detailTransactions = detailTransactions;
	}
	public List<CartPromotion> getCartPromotions() {
		return cartPromotions;
	}
	public void setCartPromotions(List<CartPromotion> cartPromotions) {
		this.cartPromotions = cartPromotions;
	}
	public ItemMaster getItemMaster() {
		return itemMaster;
	}
	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeightType() {
		return weightType;
	}
	public void setWeightType(String weightType) {
		this.weightType = weightType;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
