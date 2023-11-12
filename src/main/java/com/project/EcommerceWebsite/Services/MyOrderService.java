package com.project.EcommerceWebsite.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.EcommerceWebsite.DTO.OrderDto;
import com.project.EcommerceWebsite.Entities.CartItems;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Entities.MyOrder;
import com.project.EcommerceWebsite.Repository.CartItemsRepo;
import com.project.EcommerceWebsite.Repository.MyOrderRepo;

@Service
public class MyOrderService {
	
	@Autowired
	private MyOrderRepo orderRepo;
	
	@Autowired
	private CartItemsRepo cartItemsRepo;
	
	public ResponseEntity<?> retriveOrderHistory(Customer customer){
		
		List<MyOrder> orders= orderRepo.findByCustomer(customer);
		return ResponseEntity.status(HttpStatus.OK).body(orders);	
	}
	
	public ResponseEntity<?> addToOrder(Customer customer,OrderDto orderDto){
		List<CartItems> items=cartItemsRepo.findByCustomer(customer);
		if(items.size()==0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart item is empty");
		}
		MyOrder order= new MyOrder();
		order.setCartItem(items);
		order.setCustomer(customer);
		order.setOrderDate(new Date().toString());
		order.setOrderAddress(orderDto.getOrderAddress());
		order.setOrderStatus(orderDto.getOrderStatus());
		MyOrder orderItem=orderRepo.save(order);
		if(orderItem!=null) {
		cartItemsRepo.deleteCartItemsByCustomer(customer.getId());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(orderItem);
	}

}
