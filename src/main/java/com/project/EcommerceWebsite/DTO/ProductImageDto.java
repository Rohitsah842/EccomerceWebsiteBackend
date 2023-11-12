package com.project.EcommerceWebsite.DTO;

import jakarta.persistence.Column;

public class ProductImageDto {
	
	private String fileName;
	private String filePath;
	
	public ProductImageDto() {
		super();
		// TODO Auto-generated constructor stub
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
