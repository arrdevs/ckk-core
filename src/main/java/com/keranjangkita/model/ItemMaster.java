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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ITEM_MASTER")
public class ItemMaster {

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "master_item_id")
    private String id;
	@Column(name="item_code")
	private String itemCode;
	@Column(name="bar_code")
	private String barCode;
	private String name;
	private String weight;
	@Column(name="weight_type")
	private String weightType;
	// panjang lebar tinggi (PLT)
	//panjang
	@Column(name="length_of_item")
	private String lengthOfItem;
	//lebar
	@Column(name="width_of_item")
	private String widthOfItem;
	//tinggi
	@Column(name="height_of_item")
	private String heightOfItem;
	private String description;
	private String price;
	private String netto;
	private String brutto;
	@Column(name="stock")
	private Integer inStock;
	//unite of measure
	private String uom;
	@Column(name="amount_availability")
	private Integer amount_availability;
	@Column(name="image_url")
	private String imageUrl;
	private String status;
	@OneToMany(mappedBy="itemMaster", fetch=FetchType.LAZY)
    private List<CartDetail> cartDetails;
	@OneToMany(mappedBy="itemMaster", fetch=FetchType.LAZY)
	private List<Item> items;
	private String note;
	@Transient
	private String statusItem;
	@Transient
	private String statusStock;
	@Transient
	private int qty;
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
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getLengthOfItem() {
		return lengthOfItem;
	}
	public void setLengthOfItem(String lengthOfItem) {
		this.lengthOfItem = lengthOfItem;
	}
	public String getWidthOfItem() {
		return widthOfItem;
	}
	public void setWidthOfItem(String widthOfItem) {
		this.widthOfItem = widthOfItem;
	}
	public String getHeightOfItem() {
		return heightOfItem;
	}
	public void setHeightOfItem(String heightOfItem) {
		this.heightOfItem = heightOfItem;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
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
	public Integer getInStock() {
		return inStock;
	}
	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}
	public Integer getAmount_availability() {
		return amount_availability;
	}
	public void setAmount_availability(Integer amount_availability) {
		this.amount_availability = amount_availability;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Column(name="create_user")
	private String createUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
}
