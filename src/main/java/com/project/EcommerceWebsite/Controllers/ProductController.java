package com.project.EcommerceWebsite.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.EcommerceWebsite.DTO.ProductDto;
import com.project.EcommerceWebsite.Entities.Product;
import com.project.EcommerceWebsite.Entities.ProductImage;
import com.project.EcommerceWebsite.Services.ProductImageService;
import com.project.EcommerceWebsite.Services.ProductService;

@RestController
//@CrossOrigin(allowedHeaders = {"Authorization", "Origin"}, allowCredentials = "true" ,exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RequestMapping("/Ecommerce")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductImageService prodImgSer;
	
	@PostMapping("/add-product")
	public ResponseEntity<?> addProduct(@RequestParam("data") String productDto, @RequestParam("image")MultipartFile file) throws IOException{
//		ProductImage ProductImage=prodImgSer.uploadImage(file);
//		return productService.addProduct(productDto, ProductImage);
		return ResponseEntity.ok(productDto);
	}
	
	@GetMapping("/product")
	public ResponseEntity<?> getAllProduct(){
		
		return productService.getAllProduct();
	}
	
	@GetMapping("/product/{name}")
	public ResponseEntity<?> getProductByName(@RequestParam String name){
		 Product product=productService.getProductByName(name);
		 
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}

}
