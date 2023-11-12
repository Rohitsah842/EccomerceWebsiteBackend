package com.project.EcommerceWebsite.Entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_item")
public class CartItems {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Cart_Id")
	private Long id;
	
	
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="productId")
	private Product product;

	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@Column(name="quantity")
	private int quantity;

	public CartItems(Long id, Product product, Customer customer, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
	}

	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	

}
