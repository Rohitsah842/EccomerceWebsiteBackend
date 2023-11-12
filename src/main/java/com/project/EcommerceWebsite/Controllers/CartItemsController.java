package com.project.EcommerceWebsite.Controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Repository.CustomerRepo;
import com.project.EcommerceWebsite.Services.CartItemsService;
import com.project.EcommerceWebsite.Services.CustomerService;
import com.project.EcommerceWebsite.Services.JWTService;

@RestController
@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RequestMapping("/Ecommerce")
public class CartItemsController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CartItemsService cartItemsService;
	
	@PostMapping("/addToCart/{pid}/{qty}")
	public ResponseEntity<?> addItemToCart(@PathVariable("pid") long pid, @PathVariable("qty") int qty ){
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerRepo.findByEmail(email);
		return cartItemsService.addToCart(pid, qty, customer);
//		return ResponseEntity.status(HttpStatus.OK).body(qty+pid);
		
	}
	
	@GetMapping("/cartItems")
	public ResponseEntity<?> fetchCartItems(){
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerRepo.findByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(cartItemsService.listCartItem(customer));
	}
	@PostMapping("/update-quantity/{pid}/{qty}")
	public ResponseEntity<?> updateQuantity(@PathVariable("pid") long pid, @PathVariable("qty") int qty ){
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerRepo.findByEmail(email);
		return cartItemsService.updateQuantity(pid, qty, customer);
//		return ResponseEntity.status(HttpStatus.OK).body(qty+pid);
		
	}
	
	@DeleteMapping("/deleteCartItem/{pid}")
	public void deleteCartItems(@PathVariable("pid") long pid){
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerRepo.findByEmail(email);
		 cartItemsService.removeItem(pid,customer);
	}
	

}
