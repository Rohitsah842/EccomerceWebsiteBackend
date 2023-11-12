package com.project.EcommerceWebsite.DTO;

import java.util.List;

import com.project.EcommerceWebsite.Entities.ProductImage;

import jakarta.validation.constraints.NotNull;



public class ProductDto {
	
	@NotNull
	private String name;
	@NotNull
	private long MRP;
	@NotNull
	private int price;
	@NotNull
	private List<String> description;
	@NotNull
	private int noOfQuantity;
	@NotNull
	private String category;
	
	ProductImage productImage;
	
	
	public ProductDto( String name, long mRP, int price, List<String> description, int noOfQuantity, String category, ProductImage productImage) {
		super();
		this.name = name;
		MRP = mRP;
		this.price = price;
		this.description = description;
		this.noOfQuantity = noOfQuantity;
		this.category=category;
		this.productImage=productImage;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMRP() {
		return MRP;
	}
	public void setMRP(long mRP) {
		MRP = mRP;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<String> getDescription() {
		return description;
	}
	public void setDescription(List<String> description) {
		this.description = description;
	}
	public int getNoOfQuantity() {
		return noOfQuantity;
	}
	public void setNoOfQuantity(int noOfQuantity) {
		this.noOfQuantity = noOfQuantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ProductImage getProductImage() {
		return productImage;
	}
	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	
	

}
