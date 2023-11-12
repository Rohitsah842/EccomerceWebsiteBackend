package com.project.EcommerceWebsite.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.EcommerceWebsite.DTO.CartItemsDto;
import com.project.EcommerceWebsite.Entities.CartItems;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Entities.Product;
import com.project.EcommerceWebsite.Repository.CartItemsRepo;
import com.project.EcommerceWebsite.Repository.ProductRepo;

@Service
public class CartItemsService {

	@Autowired
	private CartItemsRepo cartItemsRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public ResponseEntity<List<CartItems>> listCartItem(Customer customer){
		return ResponseEntity.ok(cartItemsRepo.findByCustomer(customer));
		
	}
	
	public ResponseEntity<?> addToCart(long ProductId, int quantity, Customer customer){
		Integer addQuantity=quantity;
		Product product=productRepo.findById(ProductId);
//		CartItems cartItems=null;
		if(product==null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Product doesn't exist");
		}
		
		CartItems cartItems=cartItemsRepo.findByCustomerAndProduct(customer,product);
//		
		if(cartItems!=null) {
			cartItems.setQuantity(cartItems.getQuantity()+addQuantity);
		}else {
			 cartItems=new CartItems();
			 cartItems.setCustomer(customer);
			 cartItems.setProduct(product);
			 cartItems.setQuantity(addQuantity);
		}
		
		cartItemsRepo.save(cartItems);
		return ResponseEntity.status(HttpStatus.CREATED).body(addQuantity);
	}
	
	public ResponseEntity<?> updateQuantity(long productId, int quantity, Customer customer) {
		long cid=customer.getId();
		cartItemsRepo.updateQuantity(quantity,cid, productId);
		Product product = productRepo.findById(productId);
		float subTotal=product.getPrice()*quantity;
		return ResponseEntity.status(HttpStatus.OK).body(subTotal);
	}
	
	public void removeItem(long productId, Customer customer) {
		cartItemsRepo.deleteCartProduct(productId, customer.getId());
	}
	
}
