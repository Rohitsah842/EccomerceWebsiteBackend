package com.project.EcommerceWebsite.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class MyOrder {

	@Id
	@GeneratedValue
	@Column
	private long id;
	
	@Column
	private String orderDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cartItem_id")
	private List<CartItems> cartItem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column
	private String orderAddress;
	
	@Column
	private String orderStatus;
	
	

	

	public MyOrder(long id, String orderDate, List<CartItems> cartItem, Customer customer, String orderAddress,
			String orderStatus) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.cartItem = cartItem;
		this.customer = customer;
		this.orderAddress = orderAddress;
		this.orderStatus = orderStatus;
	}

	public MyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<CartItems> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItems> items) {
		this.cartItem = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
