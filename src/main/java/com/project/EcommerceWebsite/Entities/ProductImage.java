package com.project.EcommerceWebsite.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name="Product_Image")
@Builder
public class ProductImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Image_Id")
	private long id;
	@Column(name="Image_name")
	private String fileName;
	@Column(name="Image_Path")
	private String filePath;
	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
