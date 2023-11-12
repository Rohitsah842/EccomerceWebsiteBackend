package com.project.EcommerceWebsite.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EcommerceWebsite.DTO.SignUpDto;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Services.CustomerService;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class SignUpPage {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/sign-up")
	public ResponseEntity<Object> signUp(@RequestBody @Valid SignUpDto customerDto){
		
		 String hashPwd = passwordEncoder.encode(customerDto.getPassword());
		 customerDto.setPassword(hashPwd);
		
		return customerService.saveDetails(customerDto);
	}
	
	

	@GetMapping("/details")
	public ResponseEntity<List<Customer>> getData(){
		List<Customer> customers = null;
		try {
			customers=customerService.getCustomerDetails();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ResponseEntity.ok(customers);
	}
	@GetMapping("/details/{id}")
	public Optional<Customer> getDataById(@PathVariable("id") long id){
		return customerService.getCustomerDetailsById(id);
	}

}
