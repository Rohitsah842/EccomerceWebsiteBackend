package com.project.EcommerceWebsite.Services;

import java.util.List;

import javax.tools.JavaFileObject;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.EcommerceWebsite.DTO.ProductDto;
import com.project.EcommerceWebsite.Entities.Product;
import com.project.EcommerceWebsite.Entities.ProductImage;
import com.project.EcommerceWebsite.Repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	public ResponseEntity<?> addProduct(String productDto1, ProductImage prodImage) throws JsonMappingException, JsonProcessingException{
		
		ProductDto productDto = mapper.readValue(productDto1, ProductDto.class);
		
		Product product= new Product();
		product.setName(productDto.getName());
		product.setMRP(productDto.getMRP());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setNoOfQuantity(productDto.getNoOfQuantity());
		product.setCategory(productDto.getCategory());
		product.setProductImage(prodImage);
		
		productRepo.save(product);
		return ResponseEntity.ok("Product added successfully");
	}
	
	public ResponseEntity<List<Product>> getAllProduct(){
		
		return ResponseEntity.ok(productRepo.findAll());
	}
	
	public Product getProductByName(String name) {
		
		return productRepo.findByName(name);
	}
	
	public Product getProductById(long id) {
		
		return productRepo.findById(id);
	}

}
