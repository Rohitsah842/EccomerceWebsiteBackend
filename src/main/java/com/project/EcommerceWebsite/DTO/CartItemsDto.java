package com.project.EcommerceWebsite.DTO;

import java.util.List;

import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Entities.Product;

public class CartItemsDto {
	
	private Product product;
	
	private Customer customer;
	
	private Integer quantity;

	public CartItemsDto(Product product, Customer customer, Integer quantity) {
		super();
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
	}

	public CartItemsDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
