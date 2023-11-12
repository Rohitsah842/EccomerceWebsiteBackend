package com.project.EcommerceWebsite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EcommerceWebsite.Entities.ProductImage;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
	
	Optional<ProductImage> findByfileName(String fileName);

}
