package com.keranjangkita.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="DETAIL_TRANSACTION")
public class DetailTransaction {

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "detail_transaction_id")
    private String id;
	private int price;
	private int quantity;
	private String status;
	@Column(name="create_user")
	private String createUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	@ManyToOne
	@JoinColumn(name="transaction_id")
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item items;
	@ManyToOne
	@JoinColumn(name="cart_promotion_id")
	private CartPromotion cartPromotion;
	@OneToMany(mappedBy="detailTransaction", fetch=FetchType.LAZY)
	private List<Refund> refunds;
	@OneToMany(mappedBy="detailTransaction", fetch=FetchType.LAZY)
	private List<Retur> returnItem;
	
	public CartPromotion getCartPromotion() {
		return cartPromotion;
	}
	public void setCartPromotion(CartPromotion cartPromotion) {
		this.cartPromotion = cartPromotion;
	}
	public List<Retur> getReturnItem() {
		return returnItem;
	}
	public void setReturnItem(List<Retur> returnItem) {
		this.returnItem = returnItem;
	}
	public List<Refund> getRefunds() {
		return refunds;
	}
	public void setRefunds(List<Refund> refunds) {
		this.refunds = refunds;
	}
	
	public Item getItems() {
		return items;
	}
	public void setItems(Item items) {
		this.items = items;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
