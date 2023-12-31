package com.project.EcommerceWebsite.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.EcommerceWebsite.Entities.ProductImage;
import com.project.EcommerceWebsite.Services.ProductImageService;

@RestController
@RequestMapping("/Ecommerce")
public class ProductImageController {
	
	@Autowired
	private ProductImageService prodImgSer;
	
	@PostMapping("/upload-img")
	public ResponseEntity<?>uploadImage(@RequestParam("image")MultipartFile file) throws IOException{
		
		ProductImage prodImage=prodImgSer.uploadImage(file);
		
		return ResponseEntity.status(HttpStatus.OK).body(prodImage);
	}
	
	@GetMapping("/image/{fileName}")
	public ResponseEntity<?> getImage(@PathVariable String fileName)throws IOException{
		byte[] imageData=prodImgSer.getImage(fileName);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
						.body(imageData);
	}

}
