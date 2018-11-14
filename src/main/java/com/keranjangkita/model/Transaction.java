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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Transaction {

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "transaction_id")
    private String id;
	@Column(name="no_resi")
	private String noResi;
	@Column(name="no_transaction")
	private String noTransaction;
	@Column(name="total_price")
	private int totalPrice;
	@Column(name="note_buyer")
	private String noteBuyer;
	@Column(name="payment_method")
	private String paymentMethod;
	private String status;
	@Column(name="create_user")
	private String createUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	@ManyToOne
	@JoinColumn(name="courier_id")
	private Courier courier;
	@OneToMany(mappedBy="transaction", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<DetailTransaction> detailTransaction;
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public List<DetailTransaction> getDetailTransaction() {
		return detailTransaction;
	}
	public void setDetailTransaction(List<DetailTransaction> detailTransaction) {
		this.detailTransaction = detailTransaction;
	}
	public Courier getCourier() {
		return courier;
	}
	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNoResi() {
		return noResi;
	}
	public void setNoResi(String noResi) {
		this.noResi = noResi;
	}
	public String getNoTransaction() {
		return noTransaction;
	}
	public void setNoTransaction(String noTransaction) {
		this.noTransaction = noTransaction;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getNoteBuyer() {
		return noteBuyer;
	}
	public void setNoteBuyer(String noteBuyer) {
		this.noteBuyer = noteBuyer;
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
