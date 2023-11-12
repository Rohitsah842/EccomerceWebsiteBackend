package com.project.EcommerceWebsite.Services;

import java.awt.color.ProfileDataException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.EcommerceWebsite.Entities.ProductImage;
import com.project.EcommerceWebsite.Repository.ProductImageRepo;

@Service
public class ProductImageService {
	
	@Autowired
	private ProductImageRepo proImgRepo;
	
	private final String FolderPath="C:\\Eccomerce Project\\E-commerceWebsite\\src\\main\\resources\\static\\ProductsImages";
	
	public ProductImage uploadImage(MultipartFile file) throws IOException {
		Date date=new Date();
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(date);
		String filePath=FolderPath+timeStamp+file.getOriginalFilename();
		
		ProductImage prodImg= new ProductImage ();
		
		prodImg.setFileName(file.getOriginalFilename());
		prodImg.setFilePath(filePath);
		
		ProductImage productImage= proImgRepo.save(prodImg);
		file.transferTo(new File(filePath));
		
		if(productImage!=null) {
			return productImage;
		}
		return null;	
	}
	
	public byte[] getImage(String fileName) throws IOException {
		Optional<ProductImage>productImage=proImgRepo.findByfileName(fileName);
		
		String filePath= productImage.get().getFilePath();
		byte[] images=Files.readAllBytes(new File(filePath).toPath());
		
		return images;
	}

}
