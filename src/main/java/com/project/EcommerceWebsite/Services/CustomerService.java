package com.project.EcommerceWebsite.Services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.EcommerceWebsite.DTO.SignUpDto;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	private Customer customer;
	
	public ResponseEntity<Object> saveDetails(SignUpDto customerDto) {
		Customer customer=new Customer();
		
		
		Customer isExistingCustomer=customerRepo.findByEmail(customerDto.getEmail());
		if(isExistingCustomer==null) {
			customer.setFname(customerDto.getFname());
			customer.setLname(customerDto.getLname());
			customer.setEmail(customerDto.getEmail());
			customer.setPassword(customerDto.getPassword());
//			if(customerDto.getPassword().equals(customerDto.getConfirmPassword())) {
//			}else {
//				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Confirm Password didn't match");
//			}
			customer.setMobileNo(customerDto.getMobileNo());
			
			 customer= customerRepo.save(customer);
			return new ResponseEntity<Object>("User created sucessfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(Map.of("email","Email already exits"), HttpStatus.BAD_REQUEST);
	}
	
	public List<Customer> getCustomerDetails(){
		
		return customerRepo.findAll();
	}
	
	public Optional<Customer> getCustomerDetailsById(long id) {
		
		return customerRepo.findById(id);
	}

}
