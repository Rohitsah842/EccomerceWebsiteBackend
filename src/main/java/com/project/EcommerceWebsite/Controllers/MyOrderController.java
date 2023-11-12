package com.project.EcommerceWebsite.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EcommerceWebsite.DTO.OrderDto;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Repository.CustomerRepo;
import com.project.EcommerceWebsite.Services.MyOrderService;

@RestController
@RequestMapping("/Ecommerce")
public class MyOrderController {
	
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private MyOrderService orderService;
	
	@GetMapping("/my-order")
	public ResponseEntity<?> getListOfOrder(){
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerRepo.findByEmail(email);
		return orderService.retriveOrderHistory(customer);
	}
	
	@PostMapping("/place-order")
	public ResponseEntity<?> orderItem(@RequestBody OrderDto orderDto){
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerRepo.findByEmail(email);
		return orderService.addToOrder(customer, orderDto);
	}

}
