package com.project.EcommerceWebsite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EcommerceWebsite.Entities.Customer;



@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email);
	Customer findOneByEmailAndPassword(String email, String password);
}
