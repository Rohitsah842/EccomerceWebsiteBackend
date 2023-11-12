package com.project.EcommerceWebsite.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.EcommerceWebsite.DTO.ForgetPasswordDto;
import com.project.EcommerceWebsite.DTO.SignUpDto;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Repository.CustomerRepo;

@Service
public class ForgetPasswordService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public ResponseEntity<Object> UpdatePassword(ForgetPasswordDto forgetPasswordDto){
		
		Customer customer1=customerRepo.findByEmail(forgetPasswordDto.getEmail());
		
		if(customer1!=null) {
			if(forgetPasswordDto.getPassword().equals(forgetPasswordDto.getConfirmPassword())) {
				String hashPwd = passwordEncoder.encode(forgetPasswordDto.getPassword());
				customer1.setPassword(hashPwd);
				customer1= customerRepo.save(customer1);
				return new ResponseEntity<>("Password Update Sucessfully ", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Confirm password doesn't match with password", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email doesn't exist. ", HttpStatus.BAD_REQUEST);
	}
	

}
