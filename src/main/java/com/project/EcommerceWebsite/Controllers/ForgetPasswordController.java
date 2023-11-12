package com.project.EcommerceWebsite.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.EcommerceWebsite.DTO.ForgetPasswordDto;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Repository.CustomerRepo;
import com.project.EcommerceWebsite.Services.ForgetPasswordService;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ForgetPasswordController {
	
	@Autowired
	private ForgetPasswordService forgetPasswordService;
	
	@PutMapping("/forget-password")
	public ResponseEntity<Object> findUser(@RequestBody @Valid ForgetPasswordDto forgetPasswordDto){
		
		return forgetPasswordService.UpdatePassword(forgetPasswordDto);
	}

}
