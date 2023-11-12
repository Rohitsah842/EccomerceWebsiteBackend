package com.project.EcommerceWebsite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EcommerceWebsite.Entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	
	Product findByName(String name);

	Product findById(long id);

}
