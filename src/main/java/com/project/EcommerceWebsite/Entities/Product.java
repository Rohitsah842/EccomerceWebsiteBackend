package com.project.EcommerceWebsite.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Item_Id")
	private long id;
	@Column(name="Item_Name")
	private String name;
	@Column(name="Item_MRP")
	private long MRP;
	@Column(name="Item_Price")
	private int price;
	@Column(name="Item_Desc")
	private List<String> description;
	@Column(name="Item_Quantity")
	private int noOfQuantity;
	@Column(name="Item_Category")
	private String category;
	
	@JoinColumn(name="ProductImg_Id")
	@OneToOne(cascade = CascadeType.ALL)
	ProductImage productImage;
	
	public Product(long id, String name, long mRP, int price, List<String> description, int noOfQuantity,
			String category, ProductImage productImage) {
		super();
		this.id = id;
		this.name = name;
		MRP = mRP;
		this.price = price;
		this.description = description;
		this.noOfQuantity = noOfQuantity;
		this.category = category;
		this.productImage = productImage;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
