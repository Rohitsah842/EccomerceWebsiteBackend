package com.project.EcommerceWebsite.DTO;

import jakarta.validation.constraints.NotNull;

public class OrderDto {
	
	private String orderStatus;
	
	@NotNull
	private String orderAddress;

	public OrderDto(String orderStatus, @NotNull String orderAddress) {
		super();
		this.orderStatus = orderStatus;
		this.orderAddress = orderAddress;
	}

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	
}
